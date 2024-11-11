package store.domain;

import static store.util.Constant.MEMBERSHIP_DISCOUNT_LIMIT;
import static store.util.Constant.MEMBERSHIP_DISCOUNT_RATE;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Receipt {

    private final Map<Product, Integer> purchaseHistory;
    private final Map<Product, Integer> giveAwayHistory;
    private int membershipApplicableAmount;

    public Receipt() {
        purchaseHistory = new LinkedHashMap<>();
        giveAwayHistory = new LinkedHashMap<>();
    }

    public void addPurchaseHistory(Product product, int quantity) {
        purchaseHistory.put(product, quantity);
    }

    public void addGiveAwayHistory(Product product, Promotion promotion, int quantity) {
        int bundle = promotion.getBuy() + promotion.getGet();
        int giveAwayQuantity = Math.min(quantity, product.getQuantity()) / bundle;
        if (giveAwayQuantity != 0) {
            giveAwayHistory.put(product, giveAwayQuantity);
        }
    }

    public void applyMembershipDiscount(Promotions promotions) {
        for (Map.Entry<Product, Integer> purchaseInfo : purchaseHistory.entrySet()) {
            Product product = purchaseInfo.getKey();
            int quantity = purchaseInfo.getValue();
            if (!hasGiveAway(product.getName())) {
                membershipApplicableAmount += product.getPrice() * quantity;
                continue;
            }
            int promotionApplicableQuantity = calculatePromotionApplicableQuantity(product, promotions);
            membershipApplicableAmount += product.getPrice() * (quantity - promotionApplicableQuantity);
        }
    }

    private int calculatePromotionApplicableQuantity(Product product, Promotions promotions) {
        int giveAwayQuantity = findGiveAwayQuantity(product.getName());
        Promotion promotion = promotions.findPromotion(product.getPromotionName());
        int bundle = promotion.calculateBundle();
        return bundle * giveAwayQuantity;
    }

    private boolean hasGiveAway(String productName) {
        for (Map.Entry<Product, Integer> giveAwayInfo : giveAwayHistory.entrySet()) {
            Product product = giveAwayInfo.getKey();
            if (productName.equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    private int findGiveAwayQuantity(String productName) {
        for (Map.Entry<Product, Integer> giveAwayInfo : giveAwayHistory.entrySet()) {
            Product product = giveAwayInfo.getKey();
            if (productName.equals(product.getName())) {
                return giveAwayInfo.getValue();
            }
        }
        return 0;
    }

    public int calculateTotalPurchaseAmount() {
        int totalPurchaseAmount = 0;
        for (Map.Entry<Product, Integer> giveAway : purchaseHistory.entrySet()) {
            Product product = giveAway.getKey();
            int quantity = giveAway.getValue();
            totalPurchaseAmount += product.getPrice() * quantity;
        }
        return totalPurchaseAmount;
    }

    public int calculateTotalQuantity() {
        int totalQuantity = 0;
        for (Integer quantity : purchaseHistory.values()) {
            totalQuantity += quantity;
        }
        return totalQuantity;
    }

    public int calculatePromotionDiscount() {
        int promotionDiscount = 0;
        for (Map.Entry<Product, Integer> giveAway : giveAwayHistory.entrySet()) {
            Product product = giveAway.getKey();
            int quantity = giveAway.getValue();
            promotionDiscount += product.getPrice() * quantity;
        }
        return promotionDiscount;
    }

    public int calculateMembershipDiscount() {
        int membershipDiscount = (int) (membershipApplicableAmount * MEMBERSHIP_DISCOUNT_RATE);
        return Math.min(MEMBERSHIP_DISCOUNT_LIMIT, membershipDiscount);
    }

    public int calculatePayment() {
        int totalPurchaseAmount = calculateTotalPurchaseAmount();
        int promotionDiscount = calculatePromotionDiscount();
        int membershipDiscount = calculateMembershipDiscount();
        return totalPurchaseAmount - promotionDiscount - membershipDiscount;
    }

    public Map<Product, Integer> getPurchaseHistory() {
        return Collections.unmodifiableMap(purchaseHistory);
    }

    public Map<Product, Integer> getGiveAwayHistory() {
        return Collections.unmodifiableMap(giveAwayHistory);
    }
}
