package store.view;

import static store.view.Constant.ORDER_MESSAGE;
import static store.view.MessageTemplate.PROMOTION_BENEFIT;
import static store.view.MessageTemplate.PROMOTION_QUANTITY_SHORTAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends View {

    public static String readOrder() {
        printNewLine();
        printMessage(ORDER_MESSAGE);
        return Console.readLine();
    }

    public static String readForAdditionalItem(String productName) {
        printNewLine();
        printMessage(PROMOTION_BENEFIT.format(productName));
        return Console.readLine();
    }

    public static String readForOutOfStock(String productName, int shortageQuantity) {
        printNewLine();
        printMessage(PROMOTION_QUANTITY_SHORTAGE.format(productName, shortageQuantity));
        return Console.readLine();
    }
}
