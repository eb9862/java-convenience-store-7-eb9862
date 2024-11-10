package store;

import static store.util.ErrorMessage.INVALID_INPUT_MESSAGE;
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

    Map<String, Integer> shoppingCart;
    Receipt receipt;

    PaymentService(Inventory inventory, Promotions promotions, Order order) {
        shoppingCart = new LinkedHashMap<>();
        receipt = new Receipt();
        checkBenefitOrOutOfStock(inventory, promotions, order);
        updatePurchaseHistory(inventory);
        updateGiveAwayHistory(inventory, promotions, order);

    }

    void updatePurchaseHistory(Inventory inventory) {
        shoppingCart.forEach((productName, quantity) -> {
            Product product = inventory.findProductWithPromotion(productName);
            if (product == null) {
                product = Inventory.findProductWithoutPromotion(productName);
            }
            receipt.addPurchaseHistory(product, quantity);
        });
    }

    void updateGiveAwayHistory(Inventory inventory, Promotions promotions, Order order) {
        Map<String, Integer> orders = order.getOrders();
        orders.forEach((productName, quantity) -> {
            Product product = inventory.findProductWithPromotion(productName);
            if (product != null && promotions.isPromotionApplicable(product)) {
                Promotion promotion = promotions.findPromotion(product.getPromotionName());
                receipt.addGiveAwayHistory(product, promotion, quantity);
            }
        });
    }

    void checkBenefitOrOutOfStock(Inventory inventory, Promotions promotions, Order order) {
        Map<String, Integer> orders = order.getOrders();
        orders.forEach((productName, quantity) -> {
            shoppingCart.put(productName, quantity);
            Product product = inventory.findProductWithPromotion(productName);
            if (product != null && promotions.isPromotionApplicable(product)) {
                Promotion promotion = promotions.findPromotion(product.getPromotionName());
                if (canApplyPromotionBenefit(product, promotion, Map.entry(productName, quantity))) {
                    if (inputForAdditionalItem(productName).equals("Y")) {
                        shoppingCart.put(productName, quantity + 1);
                    }
                    return;
                }
                checkOutOfStock(product, promotion, Map.entry(productName, quantity));
            }
        });
    }

    boolean canApplyPromotionBenefit(Product product, Promotion promotion, Map.Entry<String, Integer> order) {
        int bundle = promotion.getBuy() + promotion.getGet();
        int quantity = order.getValue();
        if (quantity < product.getQuantity()) {
            return quantity % bundle == bundle - 1;
        }
        return false;
    }

    void checkOutOfStock(Product product, Promotion promotion, Map.Entry<String, Integer> order) {
        int bundle = promotion.getBuy() + promotion.getGet();
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

    String inputForOutOfStock(String productName, int shortageQuantity) {
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

    String inputForAdditionalItem(String productName) {
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

    String inputForMembershipDiscount() {
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

    static void validateAnswer(String answer) {
        if (!answer.equals("Y") && !answer.equals("N")) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
}
