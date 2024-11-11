package store.domain;

import static store.util.Constant.PROMOTIONS_FILE_NAME;

import camp.nextstep.edu.missionutils.DateTimes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Promotions {

    private final List<Promotion> promotions;

    public Promotions() throws IOException {
        this.promotions = new ArrayList<>();
        loadFromFile();
    }

    private void loadFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(PROMOTIONS_FILE_NAME));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            List<Object> promotionInfo = parsePromotionInfo(line);
            promotions.add(createPromotion(promotionInfo));
        }
        br.close();
    }

    private static List<Object> parsePromotionInfo(String line) {
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

    private static Promotion createPromotion(List<Object> promotionInfo) {
        String name = (String) promotionInfo.getFirst();
        int buy = (int) promotionInfo.get(1);
        int get = (int) promotionInfo.get(2);
        LocalDateTime startDate = (LocalDateTime) promotionInfo.get(3);
        LocalDateTime endDate = (LocalDateTime) promotionInfo.getLast();
        return new Promotion(name, buy, get, startDate, endDate);
    }

    public boolean isPromotionApplicable(Product product) {
        for (Promotion promotion : promotions) {
            if (product.getPromotionName().equals(promotion.getName())) {
                return promotion.canApply(DateTimes.now());
            }
        }
        return false;
    }

    public Promotion findPromotion(String promotionName) {
        for (Promotion promotion : promotions) {
            if (promotionName.equals(promotion.getName())) {
                return promotion;
            }
        }
        return null;
    }
}
