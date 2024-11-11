package store.view;

public enum MessageTemplate {

    PRODUCT_INFO("- %s %,d원 %d개 %s"),
    PRODUCT_INFO_ZERO_QUANTITY("- %s %,d원 재고 없음 %s"),
    PROMOTION_BENEFIT("현재 %s은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)"),
    PROMOTION_QUANTITY_SHORTAGE("현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)"),

    RECEIPT_HEADER("%-15s\t%-9s%s"),
    RECEIPT_PURCHASE_HISTORY("%-15s\t%-10d%,d"),
    RECEIPT_GIVEAWAY_HISTORY("%-15s\t%d"),
    RECEIPT_TOTAL_PURCHASE_AMOUNT("%-15s\t%-10d%,d"),
    RECEIPT_PROMOTION_DISCOUNT("%-15s\t%-9s -%,d"),
    RECEIPT_MEMBERSHIP_DISCOUNT("%-15s\t%-9s -%,d"),
    RECEIPT_PAYMENT("%-15s\t%-10s %,d");

    private final String messageTemplate;

    MessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    String format(Object... args) {
        return String.format(messageTemplate, args);
    }
}