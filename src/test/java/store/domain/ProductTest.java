package store.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    @DisplayName("상품의 promotion이 \"null\"일 경우 빈문자열을 대입")
    void checkPromotionNameIsNullToBlank() {

        String name = "test";
        int price = 0;
        int quantity = 0;
        String promotion = "null";

        Product testProduct = new Product(name, price, quantity, promotion);

        assertThat(testProduct.getPromotionName()).isBlank();
    }

    @Test
    @DisplayName("상품의 수량이 0이면 true, 아니라면 false 반환하는 하는지 확인")
    void checkQuantityIsZero() {

        String name = "test";
        int price = 0;
        int quantity = 0;
        String promotion = "null";

        Product testProduct = new Product(name, price, quantity, promotion);

        assertThat(testProduct.isZeroQuantity()).isTrue();
    }

    @Test
    @DisplayName("promotion이 존재할 경우 true, 아닐 경우 false 반환")
    void checkPromotionExistence() {

        String name = "test";
        int price = 0;
        int quantity = 0;
        String promotion = "null";

        Product testProduct = new Product(name, price, quantity, promotion);

        assertThat(testProduct.hasPromotion()).isFalse();
    }
}