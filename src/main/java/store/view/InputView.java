package store.view;

import static store.util.Constant.ADDITIONAL_PURCHASE_MESSAGE;
import static store.util.Constant.MEMBERSHIP_DISCOUNT_MESSAGE;
import static store.util.Constant.ORDER_MESSAGE;
import static store.util.MessageTemplate.PROMOTION_BENEFIT;
import static store.util.MessageTemplate.PROMOTION_QUANTITY_SHORTAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends View {

    private InputView() {}

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

    public static String readForMembershipDiscount() {
        printNewLine();
        printMessage(MEMBERSHIP_DISCOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String readForAdditionalPurchase() {
        printNewLine();
        printMessage(ADDITIONAL_PURCHASE_MESSAGE);
        return Console.readLine();
    }
}
