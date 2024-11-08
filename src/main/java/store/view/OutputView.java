package store.view;

import static store.view.Constant.INTRODUCE_PRODUCT_MESSAGE;
import static store.view.ErrorMessage.ERROR_TAG;
import static store.view.OutputMessage.PRODUCT_INFO;
import static store.view.OutputMessage.PRODUCT_INFO_ZERO_QUANTITY;

import java.util.List;
import store.domain.Inventory;
import store.domain.Product;

public class OutputView {

    public static void printInventory(Inventory inventory) {
        printMessage(INTRODUCE_PRODUCT_MESSAGE);
        printNewLine();
        List<Product> products = inventory.getProducts();
        for (Product product : products) {
            printProductInfo(product);
        }
    }

    public static void printProductInfo(Product product) {
        if (!product.isZeroQuantity()) {
            printMessage(PRODUCT_INFO.format(product.getName(), product.getPrice(), product.getQuantity(), product.getPromotionName()));
            return;
        }
        printMessage(PRODUCT_INFO_ZERO_QUANTITY.format(product.getName(), product.getPrice(), product.getPromotionName()));
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printError(String errorMessage) {
        printMessage(ERROR_TAG + errorMessage);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
