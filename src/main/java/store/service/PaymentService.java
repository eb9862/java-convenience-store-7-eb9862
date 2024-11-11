package store.service;

import static store.util.Validator.validateAnswer;
import static store.view.InputView.readForAdditionalItem;
import static store.view.InputView.readForMembershipDiscount;
import static store.view.InputView.readForOutOfStock;

import java.util.LinkedHashMap;
import java.util.Map;
import store.domain.Inventory;
import store.domain.Order;
import store.domain.Product;
import store.domain.Promotion;
import store.domain.Promotions;
import store.domain.Receipt;
import store.view.OutputView;

public class PaymentService {

    private final Map<String, Integer> shoppingCart;
    private final Receipt receipt;

    public PaymentService(Inventory inventory, Promotions promotions, Order order) {
        shoppingCart = new LinkedHashMap<>();
        receipt = new Receipt();
        checkPromotionProduct(inventory, promotions, order);
        updatePurchaseHistory(inventory);
        updateGiveAwayHistory(inventory, promotions, order);
        updateInventory(inventory, promotions);
        checkMembershipDiscount(promotions);
    }

    private void checkMembershipDiscount(Promotions promotions) {
        String answer = inputForMembershipDiscount();
        if (answer.equals("Y")) {
            receipt.applyMembershipDiscount(promotions);
        }
    }

    private void updateInventory(Inventory inventory, Promotions promotions) {
        shoppingCart.forEach((productName, quantity) -> {
            Product product = inventory.findProductWithPromotion(productName);
            if (product != null && promotions.isPromotionApplicable(product)) {
                inventory.reducePromotionStock(productName, quantity);
                return;
            }
            inventory.reduceNotPromotionStock(productName, quantity);
        });
    }

    private void updatePurchaseHistory(Inventory inventory) {
        shoppingCart.forEach((productName, quantity) -> {
            Product product = inventory.findProductWithPromotion(productName);
            if (product == null) {
                product = inventory.findProductWithoutPromotion(productName);
            }
            receipt.addPurchaseHistory(product, quantity);
        });
    }

    private void updateGiveAwayHistory(Inventory inventory, Promotions promotions, Order order) {
        shoppingCart.forEach((productName, quantity) -> {
            Product product = inventory.findProductWithPromotion(productName);
            if (product != null && promotions.isPromotionApplicable(product)) {
                Promotion promotion = promotions.findPromotion(product.getPromotionName());
                receipt.addGiveAwayHistory(product, promotion, quantity);
            }
        });
    }

    private void checkPromotionProduct(Inventory inventory, Promotions promotions, Order order) {
        Map<String, Integer> orders = order.getOrders();
        orders.forEach((productName, quantity) -> {
            shoppingCart.put(productName, quantity);
            Product product = inventory.findProductWithPromotion(productName);
            if (product != null && promotions.isPromotionApplicable(product)) {
                Promotion promotion = promotions.findPromotion(product.getPromotionName());
                checkBenefitOrOutOfStock(product, promotion, Map.entry(productName, quantity));
            }
        });
    }

    private void checkBenefitOrOutOfStock(Product product, Promotion promotion, Map.Entry<String, Integer> order) {
        String productName = order.getKey();
        int quantity = order.getValue();
        if (canApplyPromotionBenefit(product, promotion, Map.entry(productName, quantity))) {
            if (inputForAdditionalItem(productName).equals("Y")) {
                shoppingCart.put(productName, quantity + 1);
            }
            return;
        }
        checkOutOfStock(product, promotion, Map.entry(productName, quantity));
    }

    private boolean canApplyPromotionBenefit(Product product, Promotion promotion, Map.Entry<String, Integer> order) {
        int bundle = promotion.calculateBundle();
        int quantity = order.getValue();
        if (quantity < product.getQuantity()) {
            return quantity % bundle == bundle - 1;
        }
        return false;
    }

    private void checkOutOfStock(Product product, Promotion promotion, Map.Entry<String, Integer> order) {
        int bundle = promotion.calculateBundle();
        int shareOfOrder = order.getValue() / bundle;
        int shareOfProduct = product.getQuantity() / bundle;
        int shortageQuantity = order.getValue() - (Math.min(shareOfOrder, shareOfProduct) * bundle);
        if (shortageQuantity != 0) {
            String answer = inputForOutOfStock(order.getKey(), shortageQuantity);
            if (answer.equals("N")) {
                shoppingCart.put(order.getKey(), order.getValue() - shortageQuantity);
            }
        }
    }

    private String inputForOutOfStock(String productName, int shortageQuantity) {
        while (true) {
            try {
                String answer = readForOutOfStock(productName, shortageQuantity);
                validateAnswer(answer);
                return answer;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private String inputForAdditionalItem(String productName) {
        while (true) {
            try {
                String answer = readForAdditionalItem(productName);
                validateAnswer(answer);
                return answer;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private String inputForMembershipDiscount() {
        while (true) {
            try {
                String answer = readForMembershipDiscount();
                validateAnswer(answer);
                return answer;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public Receipt getReceipt() {
        return receipt;
    }
}
