package store.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Receipt {

    public Map<Product, Integer> purchaseHistory;
    Map<Product, Integer> giveAwayHistory;
    List<PurchaseDetails> purchaseDetailsList;
    int membershipApplicableAmount;

    public Receipt() {
        purchaseHistory = new LinkedHashMap<>();
        giveAwayHistory = new LinkedHashMap<>();
        purchaseDetailsList = new ArrayList<>();
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

    public void applyMembershipDiscount() {
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
        return 0;
    }

    public int calculatePayment() {
        int totalPurchaseAmount = calculateTotalPurchaseAmount();
        int promotionDiscount = calculatePromotionDiscount();
        int membershipDiscount = calculateMembershipDiscount();
        return totalPurchaseAmount - promotionDiscount - membershipDiscount;
    }

//    public void addOrderWithoutPromotion(Product product, int quantity) {}

    public Map<Product, Integer> getPurchaseHistory() {
        return Collections.unmodifiableMap(purchaseHistory);
    }

    public Map<Product, Integer> getGiveAwayHistory() {
        return Collections.unmodifiableMap(giveAwayHistory);
    }
}
