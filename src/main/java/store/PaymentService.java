package store;

import static store.util.ErrorMessage.INVALID_INPUT_MESSAGE;
import static store.view.InputView.readForAdditionalItem;
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

    PaymentService() {
        shoppingCart = new LinkedHashMap<>();
        receipt = new Receipt();
    }

    void promotionService(Inventory inventory, Promotions promotions, Order order) {
        Map<String, Integer> orders = order.getOrders();
        orders.forEach((productName, quantity) -> {
            shoppingCart.put(productName, quantity);
            Product product = inventory.findProductWithPromotion(productName);
            if (product != null && promotions.isPromotionApplicable(product)) {
                Promotion promotion = promotions.findPromotion(product.getPromotionName());

                boolean hasPromotionBenefit = false;
                if (canApplyPromotion(product, promotion, Map.entry(productName, quantity))) {
                    hasPromotionBenefit = true;
                    if (inputForAdditionalItem(productName).equals("Y")) {
                        shoppingCart.put(productName, quantity + 1);
                    }
                }
                if (!hasPromotionBenefit) {
                    checkOutOfStock(product, promotion, Map.entry(productName, quantity));
                }
            }
        });
    }

    static boolean canApplyPromotion(Product product, Promotion promotion, Map.Entry<String, Integer> order) {
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

    static String inputForOutOfStock(String productName, int shortageQuantity) {
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

    static String inputForAdditionalItem(String productName) {
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

    static void validateAnswer(String answer) {
        if (!answer.equals("Y") && !answer.equals("N")) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
}
