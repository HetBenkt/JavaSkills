package nl.bos.projecteuler;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class PowerDigitSum {
    public static void main(String[] args) {
        BigDecimal pow = new BigDecimal("2").pow(1000);
        char[] values = pow.toString().replace(",", "").toCharArray();
        int sum = 0;
        for (char value : values) {
            sum += Character.getNumericValue(value);
        }
        System.out.println(MessageFormat.format("Result {0}", sum));
    }
}
