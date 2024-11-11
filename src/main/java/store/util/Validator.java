package store.util;

import static store.util.ErrorMessage.INVALID_INPUT_MESSAGE;

public class Validator {

    private Validator() {}

    public static void validateAnswer(String answer) {
        if (!answer.equals("Y") && !answer.equals("N")) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
}
