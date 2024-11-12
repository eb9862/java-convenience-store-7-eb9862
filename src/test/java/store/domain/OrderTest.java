package store.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("올바른 입력값에 대해서 정확히 값이 저장되었는지 확인")
    void checkValidInput() {

        assertDoesNotThrow(() -> new Order("[사이다-2],[콜라-1]"));
    }

    @Test
    @DisplayName("쉼표로 나눠진 주문이 대괄호로 쌓여있지 않은 경우 에러 처리")
    void checkNotEnclosedSquareBracket() {

        assertThatThrownBy(() -> new Order("[사이다-2],[콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("대괄호로 쌓여진 부분이 하이픈이 하나가 아니면 에러 처리")
    void checkNotSeparatedTwoPartsWithHyphen() {

        assertThatThrownBy(() -> new Order("[사이다-2],[콜-라-1]"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("대괄호로 쌓여진 부분이 하이픈이 하나가 아니면 에러 처리")
    void checkQuantityNaturalNumber() {

        assertThatThrownBy(() -> new Order("[사이다-2],[콜라-0]"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}