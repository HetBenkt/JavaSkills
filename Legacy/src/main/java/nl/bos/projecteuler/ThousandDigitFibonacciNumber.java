package nl.bos.projecteuler;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.text.MessageFormat;

class ThousandDigitFibonacciNumber {
    @Test
    void doTest() {
        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        BigInteger fn;

        int index = 2;
        do {
            fn = f1.add(f2);
            f1 = f2;
            f2 = fn;
            index++;
        } while (fn.toString().length() < 1000);

        System.out.println(MessageFormat.format("{0} -> {1}", index, String.valueOf(fn)));
    }
}
