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
