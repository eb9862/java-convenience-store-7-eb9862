package store.domain;

import static store.util.Constant.BLANK;
import static store.util.ErrorMessage.INVALID_ORDER_MESSAGE;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private final Map<String, Integer> orders;

    public Order(String orderInput) {
        this.orders = new LinkedHashMap<>();
        validate(orderInput);
        putToOrders(orderInput);
    }

    private void putToOrders(String orderInput) {
        List<String> orderParts = List.of(orderInput.split(","));
        for (String orderPart : orderParts) {
            parseOrder(orderPart);
        }
    }

    private void parseOrder(String orderPart) {
        String orderPartNoBracket = removeSquareBracket(orderPart);
        List<String> productNameAndQuantity = List.of(orderPartNoBracket.split("-"));
        String name = productNameAndQuantity.getFirst();
        String quantityPart = productNameAndQuantity.getLast();
        int quantity = Integer.parseInt(quantityPart);
        orders.put(name, quantity);
    }

    private void validate(String orderInput) {
        List<String> splitComma = List.of(orderInput.split(","));
        for (String productNameAndQuantity : splitComma) {
            checkSquareBracket(productNameAndQuantity);
            checkSeparatedTwoPart(productNameAndQuantity);
        }
    }

    private void checkSquareBracket(String order) {
        if (!isStartAndEndWithSquareBracket(order)) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    private void checkSeparatedTwoPart(String order) {
        String orderNoBracket = removeSquareBracket(order);
        List<String> splitHyphen = List.of(orderNoBracket.split("-"));
        if (splitHyphen.size() != 2) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
        String quantity = splitHyphen.getLast();
        checkQuantityPart(quantity);
    }

    private void checkQuantityPart(String quantityPart) {
        try {
            int quantity = Integer.parseInt(quantityPart);
            if (quantity <= 0) {
                throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    private boolean isStartAndEndWithSquareBracket(String order) {
        return order.startsWith("[") && order.endsWith("]");
    }

    private String removeSquareBracket(String orderPart) {
        return orderPart.replaceAll("[\\[\\]]", BLANK);
    }

    public Map<String, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }
}
