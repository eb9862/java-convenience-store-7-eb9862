package store.util;

import static org.assertj.core.api.Assertions.assertThat;
import static store.util.FileIndex.PRODUCTS_PRICE;
import static store.util.FileIndex.PRODUCTS_QUANTITY;
import static store.util.FileIndex.PROMOTIONS_BUY;
import static store.util.FileIndex.PROMOTIONS_END_DATE;
import static store.util.FileIndex.PROMOTIONS_GET;
import static store.util.FileIndex.PROMOTIONS_START_DATE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileIndexTest {

    @Test
    @DisplayName("products.md 파일 내의 가격에 대한 index가 정확히 들어있는지 확인")
    void checkProductsPriceIndex() {

        int priceIndex = 1;

        assertThat(PRODUCTS_PRICE.getIndex()).isEqualTo(priceIndex);
    }

    @Test
    @DisplayName("products.md 파일 내의 수량에 대한 index가 정확히 들어있는지 확인")
    void checkProductsQuantityIndex() {

        int quantityIndex = 2;

        assertThat(PRODUCTS_QUANTITY.getIndex()).isEqualTo(quantityIndex);
    }

    @Test
    @DisplayName("promotions.md 파일 내의 구매 수량에 대한 index가 정확히 들어있는지 확인")
    void checkPromotionsBuyIndex() {

        int buyIndex = 1;

        assertThat(PROMOTIONS_BUY.getIndex()).isEqualTo(buyIndex);
    }

    @Test
    @DisplayName("promotions.md 파일 내의 증정 수량에 대한 index가 정확히 들어있는지 확인")
    void checkPromotionsGetIndex() {

        int getIndex = 2;

        assertThat(PROMOTIONS_GET.getIndex()).isEqualTo(getIndex);
    }

    @Test
    @DisplayName("promotions.md 파일 내의 프로모션 시작 날짜에 대한 index가 정확히 들어있는지 확인")
    void checkPromotionsStartDateIndex() {

        int startDateIndex = 3;

        assertThat(PROMOTIONS_START_DATE.getIndex()).isEqualTo(startDateIndex);
    }

    @Test
    @DisplayName("promotions.md 파일 내의 프로모션 종료 날짜에 대한 index가 정확히 들어있는지 확인")
    void checkPromotionsEndDateIndex() {

        int endDateIndex = 4;

        assertThat(PROMOTIONS_END_DATE.getIndex()).isEqualTo(endDateIndex);
    }
}