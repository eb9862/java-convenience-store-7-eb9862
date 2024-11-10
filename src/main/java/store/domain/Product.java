package store.domain;

import static store.util.Constant.BLANK;

public class Product {

    private final String name;
    private final int price;
    private int quantity;
    private final String promotionName;

    public Product(String name, int price, int quantity, String promotionName) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotionName = initPromotionName(promotionName);
    }

    private String initPromotionName(String promotionName) {
        if (promotionName.equals("null")) {
            return BLANK;
        }
        return promotionName;
    }

    public boolean isZeroQuantity() {
        return quantity == 0;
    }

    public boolean hasPromotion() {
        return !promotionName.isBlank();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPromotionName() {
        return promotionName;
    }
}
