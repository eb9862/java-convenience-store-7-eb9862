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
}
