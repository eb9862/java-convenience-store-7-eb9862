package store.util;

import static store.util.Constant.ANSWER_NO;
import static store.util.Constant.ANSWER_YES;
import static store.util.ErrorMessage.INVALID_INPUT_MESSAGE;

public class Validator {

    private Validator() {}

    public static void validateAnswer(String answer) {
        if (!answer.equals(ANSWER_YES) && !answer.equals(ANSWER_NO)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
}
