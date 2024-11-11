package store.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private Parser() {}

    public static List<Object> parseProductInfo(String line) {
        List<Object> productInfo = new ArrayList<>(List.of(line.split(",")));
        String productPrice = (String) productInfo.get(1);
        productInfo.set(1, Integer.parseInt(productPrice));
        String productQuantity = (String) productInfo.get(2);
        productInfo.set(2, Integer.parseInt(productQuantity));
        return productInfo;
    }

    public static List<Object> parsePromotionInfo(String line) {
        List<Object> promotionInfo = new ArrayList<>(List.of(line.split(",")));
        String buy = (String) promotionInfo.get(1);
        promotionInfo.set(1, Integer.parseInt(buy));
        String get = (String) promotionInfo.get(2);
        promotionInfo.set(2, Integer.parseInt(get));
        String startDate = (String) promotionInfo.get(3);
        promotionInfo.set(3, toLocalDateTime(startDate));
        String endDate = (String) promotionInfo.get(4);
        promotionInfo.set(4, toLocalDateTime(endDate));
        return promotionInfo;
    }

    private static LocalDateTime toLocalDateTime(String date) {
        LocalDate localdate = LocalDate.parse(date);
        return localdate.atStartOfDay();
    }
}
