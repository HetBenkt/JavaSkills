package nl.bos.projecteuler;

import lombok.extern.java.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;

@Log
public class ThousandDigitFibonacciNumber {
    public static void main(String[] args) {
        BigDecimal fibonacci;
        int n = 1;
        int length;

        do {
            fibonacci = getFibonacci(n);
            length = fibonacci.toString().length();
            if (length == 1000)
                log.info(MessageFormat.format("{0} -> F{1} = {2}", fibonacci.toString().length(), n, fibonacci));
            n++;
        } while (length < 1000);
    }

    private static BigDecimal getFibonacci(int n) {
        BigDecimal f1 = new BigDecimal(Double.toString((1 + Math.sqrt(5)) / 2.0)).pow(n);
        BigDecimal f2 = new BigDecimal(Double.toString((1 - Math.sqrt(5)) / 2.0)).pow(n);
        return f1.subtract(f2).divide(new BigDecimal(Double.toString(Math.sqrt(5))), 0, RoundingMode.FLOOR);
    }
}
