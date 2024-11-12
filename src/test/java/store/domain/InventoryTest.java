package store.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InventoryTest {

    private final Inventory testInventory = new Inventory();

    InventoryTest() throws IOException {
    }

    @Test
    @DisplayName("존재하지 않는 상품일 경우 에러 처리")
    void checkOrderProductNotIncludedInventory() {

        Order testOrder = new Order("[사이다-2],[환타-1]");

        assertThatThrownBy(() -> testInventory.checkOrder(testOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 수량이 재고 수량을 초과한 경우 에러 처리")
    void checkProductQuantityExceedingInventory() {

        Order testOrder = new Order("[초코바-11]");

        assertThatThrownBy(() -> testInventory.checkOrder(testOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }
  
}