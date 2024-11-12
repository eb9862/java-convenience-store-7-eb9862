package store.controller;

import static store.util.Constant.ANSWER_NO;
import static store.util.InformationMessage.WELCOME_MESSAGE;
import static store.util.Validator.validateAnswer;
import static store.view.InputView.readForAdditionalPurchase;
import static store.view.OutputView.displayReceipt;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;
import store.service.PaymentService;
import store.domain.Inventory;
import store.domain.Order;
import store.domain.Promotions;
import store.view.InputView;
import store.view.OutputView;

public class StoreController {

    private final Inventory inventory;
    private final Promotions promotions;

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
        } while (!inputAdditionalPurchase().equals(ANSWER_NO));
        closeConsole();
    }

    Inventory prepareInventory() {
        Inventory inventory;
        try {
            inventory = new Inventory();
            return inventory;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Promotions preparePromotions() {
        Promotions promotions;
        try {
            promotions = new Promotions();
            return promotions;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Order inputOrder(Inventory inventory) {
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

    String inputAdditionalPurchase() {
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

    void closeConsole() {
        Console.close();
    }
}
