package nl.bos.projecteuler;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Log
class ReciprocalCycles {
    private int maxSize;

    @Test
    void execute() {
        for (int denominator = 2; denominator <= 1000; denominator++) {
            if (isRecurring(denominator)) {
                List<Integer> remainders = new ArrayList<>();
                int numerator = 1;
                boolean finish = false;
                do {
                    int rest = numerator % denominator;
                    if(!remainders.contains(rest)) {
                        remainders.add(rest);
                        numerator = rest * 10;
                    } else {
                        remainders.add(rest);
                        finish = true;
                    }
                } while (!finish);
                if(remainders.size() > maxSize) {
                    maxSize = remainders.size();
                    log.info(MessageFormat.format("max: {0}", maxSize));
                }
            }
        }
    }

    private static boolean isRecurring(int denominator) {
        try {
            //noinspection ResultOfMethodCallIgnored,BigDecimalMethodWithoutRoundingCalled
            BigDecimal.ONE.divide(BigDecimal.valueOf(denominator));
            return false;
        } catch (ArithmeticException ae) {
            return true;
        }
    }
}