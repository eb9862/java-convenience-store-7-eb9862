package store.view;

import static store.view.Constant.ORDER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView{

    public static String readOrder() {
        OutputView.printNewLine();
        OutputView.printMessage(ORDER_MESSAGE);
        return Console.readLine();
    }
}
