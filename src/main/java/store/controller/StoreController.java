package store.controller;

import static store.util.Constant.WELCOME_MESSAGE;
import static store.util.Validator.validateAnswer;
import static store.view.InputView.readForAdditionalPurchase;
import static store.view.OutputView.displayReceipt;

import java.io.IOException;
import store.PaymentService;
import store.domain.Inventory;
import store.domain.Order;
import store.domain.Promotions;
import store.view.InputView;
import store.view.OutputView;

public class StoreController {

    Inventory inventory;
    Promotions promotions;

    public StoreController() {
        inventory = prepareInventory();
        promotions = preparePromotions();
    }

    public void run() {
        do {
            OutputView.printMessage(WELCOME_MESSAGE);
            OutputView.printInventory(inventory);
            Order order = inputOrder(inventory);
            PaymentService paymentService = new PaymentService(inventory, promotions, order);
            displayReceipt(paymentService.getReceipt());
        } while (!inputAdditionalPurchase().equals("N"));
    }

    static Inventory prepareInventory() {
        Inventory inventory;
        try {
            inventory = new Inventory();
            return inventory;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Promotions preparePromotions() {
        Promotions promotions;
        try {
            promotions = new Promotions();
            return promotions;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Order inputOrder(Inventory inventory) {
        while (true) {
            try {
                Order order = new Order(InputView.readOrder());
                inventory.checkOrder(order);
                return order;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    static String inputAdditionalPurchase() {
        while (true) {
            try {
                String answer = readForAdditionalPurchase();
                validateAnswer(answer);
                return answer;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
