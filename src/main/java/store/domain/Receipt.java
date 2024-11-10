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

    public int calculatePromotionDiscount() {
        int totalPromotionDiscount = 0;
        for (Map.Entry<Product, Integer> giveAway : giveAwayHistory.entrySet()) {
            Product product = giveAway.getKey();
            int quantity = giveAway.getValue();
            totalPromotionDiscount += product.getPrice() * quantity;
        }
        return totalPromotionDiscount;
    }

//    public void addOrderWithoutPromotion(Product product, int quantity) {}
//    calculateTotalAmount() {}
//    calculateMembershipDiscount() {}
//    calculatePayment() {}


    public Map<Product, Integer> getPurchaseHistory() {
        return Collections.unmodifiableMap(purchaseHistory);
    }

    public Map<Product, Integer> getGiveAwayHistory() {
        return Collections.unmodifiableMap(giveAwayHistory);
    }
}
