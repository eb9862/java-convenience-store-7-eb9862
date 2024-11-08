package store.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PromotionTest {

    @Test
    @DisplayName("현재 날짜가 프로모션 적용 기간이라면 true, 아니라면 false 반환")
    void checkCanApplyPromotion() {

        String name = "test";
        int buy = 2;
        int get = 1;
        LocalDateTime startDate = LocalDateTime.of(2024, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 1, 31, 23, 59);

        Promotion testPromotion = new Promotion(name, buy, get, startDate, endDate);

        assertThat(testPromotion.canApply(LocalDateTime.now())).isFalse();
        assertThat(testPromotion.canApply(LocalDateTime.of(2024,1,2,0,0))).isTrue();
    }

}