package nl.bos.projecteuler;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class FactorialDigitSum {
    private static final int FACTORIAL = 100;

    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal(FACTORIAL);
        for (int i = FACTORIAL - 1; i >= 1; i--) {
            sum = sum.multiply(new BigDecimal(i));
        }
        System.out.println(MessageFormat.format("Sum: {0}", sum));

        int totalSum = 0;
        char[] values = sum.toPlainString().toCharArray();
        for (char value : values) {
            totalSum += Character.getNumericValue(value);
        }

        System.out.println(MessageFormat.format("Result: {0}", totalSum));
    }
}
