package store.domain;

public class OrderDetails {

    String productName;
    int promotionQuantity;
    int normalQuantity;
    int giveAway;

    public OrderDetails(String productName, int promotionQuantity, int normalQuantity, int giveAway) {
        this.productName = productName;
        this.promotionQuantity = promotionQuantity;
        this.normalQuantity = normalQuantity;
        this.giveAway = giveAway;
    }
}
