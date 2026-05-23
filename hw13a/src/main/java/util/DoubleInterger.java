package main.java.util;

import java.math.BigDecimal;
public class DoubleInterger {
    private DoubleInterger() {}

    public static boolean check(String s) {
        try {
            (new BigDecimal(s)).toBigIntegerExact();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
