package store.util;

public class ErrorMessage {

    private ErrorMessage() {}

    public static final String ERROR_TAG = "[ERROR] ";
    public static final String INVALID_ORDER_MESSAGE = "올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.";
    public static final String PRODUCT_NOT_FOUND_MESSAGE = "존재하지 않는 상품입니다. 다시 입력해 주세요.";
    public static final String INSUFFICIENT_INVENTORY_MESSAGE = "재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.";
    public static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다. 다시 입력해 주세요.";
}
