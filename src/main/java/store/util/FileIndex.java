package store.util;

public enum FileIndex {

    PRODUCTS_PRICE(1),
    PRODUCTS_QUANTITY(2),
    PROMOTIONS_BUY(1),
    PROMOTIONS_GET(2),
    PROMOTIONS_START_DATE(3),
    PROMOTIONS_END_DATE(4);

    private final int index;

    FileIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
