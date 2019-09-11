package main.java.util;

import java.math.BigDecimal;

public class BillGenerationUtil {

    public static boolean isEmptyOrNull(String element) {
        return element == null || element.isEmpty();
    }


    public static float round(float number) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(Constant.TWO, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}

