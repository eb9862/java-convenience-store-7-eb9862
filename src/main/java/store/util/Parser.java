package store.util;

import static store.util.FileIndex.PRODUCTS_PRICE;
import static store.util.FileIndex.PRODUCTS_QUANTITY;
import static store.util.FileIndex.PROMOTIONS_BUY;
import static store.util.FileIndex.PROMOTIONS_END_DATE;
import static store.util.FileIndex.PROMOTIONS_GET;
import static store.util.FileIndex.PROMOTIONS_START_DATE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private Parser() {}

    public static List<Object> parseProductInfo(String line) {
        List<Object> productInfo = new ArrayList<>(List.of(line.split(",")));
        String productPrice = (String) productInfo.get(PRODUCTS_PRICE.getIndex());
        productInfo.set(PRODUCTS_PRICE.getIndex(), Integer.parseInt(productPrice));
        String productQuantity = (String) productInfo.get(PRODUCTS_QUANTITY.getIndex());
        productInfo.set(PRODUCTS_QUANTITY.getIndex(), Integer.parseInt(productQuantity));
        return productInfo;
    }

    public static List<Object> parsePromotionInfo(String line) {
        List<Object> promotionInfo = new ArrayList<>(List.of(line.split(",")));
        String buy = (String) promotionInfo.get(PROMOTIONS_BUY.getIndex());
        promotionInfo.set(PROMOTIONS_BUY.getIndex(), Integer.parseInt(buy));
        String get = (String) promotionInfo.get(PROMOTIONS_GET.getIndex());
        promotionInfo.set(PROMOTIONS_GET.getIndex(), Integer.parseInt(get));
        String startDate = (String) promotionInfo.get(PROMOTIONS_START_DATE.getIndex());
        promotionInfo.set(PROMOTIONS_START_DATE.getIndex(), toLocalDateTime(startDate));
        String endDate = (String) promotionInfo.get(PROMOTIONS_END_DATE.getIndex());
        promotionInfo.set(PROMOTIONS_END_DATE.getIndex(), toLocalDateTime(endDate));
        return promotionInfo;
    }

    private static LocalDateTime toLocalDateTime(String date) {
        LocalDate localdate = LocalDate.parse(date);
        return localdate.atStartOfDay();
    }
}
