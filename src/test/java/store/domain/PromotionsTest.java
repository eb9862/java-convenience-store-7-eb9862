package store.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertNowTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PromotionsTest {

    @Test
    @DisplayName("해당 이름을 가지는 프로모션을 정확히 찾는지 확인")
    void checkFunctionOfFindPromotion() throws IOException {

        Promotions testPromotions = new Promotions();
        String promotionName = "반짝할인";

        Promotion testPromotion = testPromotions.findPromotion(promotionName);

        assertThat(testPromotion.getName()).isEqualTo(promotionName);
    }

    @Test
    @DisplayName("프로모션 적용 가능 기간일 때는 true 반환")
    void checkFunctionOfPromotionApplicable() throws IOException {

        String name = "콜라";
        int price = 1000;
        int quantity = 7;
        String promotionName = "반짝할인";
        Product testProduct = new Product(name, price, quantity, promotionName);
        Promotions testPromotions = new Promotions();

        assertNowTest(() -> {
            boolean result = testPromotions.isPromotionApplicable(testProduct);
            assertThat(result).isTrue();
        }, LocalDate.of(2024, 11, 2).atStartOfDay());

    }

    @Test
    @DisplayName("프로모션 적용 가능 기간일 아닐때는 false 반환")
    void checkFunctionOfPromotionNotApplicable() throws IOException {

        String name = "콜라";
        int price = 1000;
        int quantity = 7;
        String promotionName = "반짝할인";
        Product testProduct = new Product(name, price, quantity, promotionName);
        Promotions testPromotions = new Promotions();

        assertNowTest(() -> {
            boolean result = testPromotions.isPromotionApplicable(testProduct);
            assertThat(result).isFalse();
        }, LocalDate.of(2024, 2, 1).atStartOfDay());

    }
}