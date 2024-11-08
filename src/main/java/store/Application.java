package store;

import static store.view.Constant.WELCOME_MESSAGE;

import java.io.IOException;
import store.domain.Inventory;
import store.domain.Promotions;
import store.view.OutputView;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        Inventory inventory = prepareInventory();
        Promotions promotions = preparePromotions();

        OutputView.printMessage(WELCOME_MESSAGE);
        OutputView.printInventory(inventory);
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
}
