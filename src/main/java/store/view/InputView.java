package store.view;

import static store.view.Constant.ORDER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends View {

    public static String readOrder() {
        printNewLine();
        printMessage(ORDER_MESSAGE);
        return Console.readLine();
    }
}
