package store;

import static store.view.Constant.WELCOME_MESSAGE;

import java.io.IOException;
import store.domain.Inventory;
import store.domain.Order;
import store.domain.Promotions;
import store.view.InputView;
import store.view.OutputView;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        Inventory inventory = prepareInventory();
        Promotions promotions = preparePromotions();

        OutputView.printMessage(WELCOME_MESSAGE);
        OutputView.printInventory(inventory);
        Order order = inputOrder(inventory);
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
                OutputView.printMessage(e.getMessage());
            }
        }
    }
}
