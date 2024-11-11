package store.view;

import static store.util.Constant.BLANK;
import static store.util.Constant.INTRODUCE_PRODUCT_MESSAGE;
import static store.util.ErrorMessage.ERROR_TAG;
import static store.util.Constant.RECEIPT_AMOUNT_INFO_TITLE;
import static store.util.Constant.RECEIPT_GIVEAWAY_TITLE;
import static store.util.Constant.RECEIPT_TITLE;
import static store.view.MessageTemplate.PRODUCT_INFO;
import static store.view.MessageTemplate.PRODUCT_INFO_ZERO_QUANTITY;
import static store.view.MessageTemplate.RECEIPT_DISCOUNT;
import static store.view.MessageTemplate.RECEIPT_GIVEAWAY_HISTORY;
import static store.view.MessageTemplate.RECEIPT_HEADER;
import static store.view.MessageTemplate.RECEIPT_PAYMENT;
import static store.view.MessageTemplate.RECEIPT_PURCHASE_HISTORY;
import static store.view.MessageTemplate.RECEIPT_TOTAL_PURCHASE_AMOUNT;

import java.util.List;
import java.util.Map;
import store.domain.Inventory;
import store.domain.Product;
import store.domain.Receipt;

public class OutputView extends View {

    private OutputView() {}

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
            printMessage(PRODUCT_INFO.format(product.getName(), product.getPrice(), product.getQuantity(),
                    product.getPromotionName()));
            return;
        }
        printMessage(
                PRODUCT_INFO_ZERO_QUANTITY.format(product.getName(), product.getPrice(), product.getPromotionName()));
    }

    public static void displayReceipt(Receipt receipt) {
        printMessage(RECEIPT_TITLE);
        printMessage(RECEIPT_HEADER.format("상품명", "수량", "금액"));
        displayPurchaseHistory(receipt);
        displayGiveAwayHistory(receipt);
        displayAmountInfo(receipt);
    }

    private static void displayAmountInfo(Receipt receipt) {
        printMessage(RECEIPT_AMOUNT_INFO_TITLE);
        printMessage(RECEIPT_TOTAL_PURCHASE_AMOUNT.format("총구매액", receipt.calculateTotalQuantity(),
                receipt.calculateTotalPurchaseAmount()));
        printMessage(RECEIPT_DISCOUNT.format("행사할인", BLANK, receipt.calculatePromotionDiscount()));
        printMessage(RECEIPT_DISCOUNT.format("멤버십할인", BLANK, receipt.calculateMembershipDiscount()));
        printMessage(RECEIPT_PAYMENT.format("내실돈", BLANK, receipt.calculatePayment()));
    }

    private static void displayGiveAwayHistory(Receipt receipt) {
        printMessage(RECEIPT_GIVEAWAY_TITLE);
        receipt.getGiveAwayHistory().forEach((product, quantity) -> {
            printMessage(RECEIPT_GIVEAWAY_HISTORY.format(product.getName(), quantity));
        });
    }

    private static void displayPurchaseHistory(Receipt receipt) {
        Map<Product, Integer> purchaseHistory = receipt.getPurchaseHistory();
        purchaseHistory.forEach((product, quantity) -> {
            printMessage(RECEIPT_PURCHASE_HISTORY.format(product.getName(), quantity, product.getPrice() * quantity));
        });
    }

    public static void printError(String errorMessage) {
        printMessage(ERROR_TAG + errorMessage);
    }
}
