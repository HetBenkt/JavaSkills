package nl.bos.projecteuler;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class NonAbundantSums {
    private static final int MAX_INT = 28123;
    private static final List<Integer> ABUNDANT_NUMBERS = new ArrayList<>();
    private static int sum = 276;

    public static void main(String[] args) {
        initAbundantNumbersList();
        int smallestAbundantNr = ABUNDANT_NUMBERS.get(0);
        for (int i = smallestAbundantNr * 2; i <= MAX_INT; i++) {
            if (!canBeWrittenAsTheSumOfTwoAbundantNumbers(i)) {
                sum += i;
            }
        }
        System.out.println(MessageFormat.format("Result is {0}", sum));
    }

    private static boolean canBeWrittenAsTheSumOfTwoAbundantNumbers(int i) {
        for (int j = 0; j < ABUNDANT_NUMBERS.size(); j++) {
            int value1 = ABUNDANT_NUMBERS.get(j);
            for (int k = 0; k < ABUNDANT_NUMBERS.size(); k++) {
                int value2 = ABUNDANT_NUMBERS.get(k);
                int sum = value1 + value2;
                if (sum == i)
                    return true;
                if (sum > i)
                    break;
            }
            if (value1 > i)
                break;
        }
        return false;
    }

    private static void initAbundantNumbersList() {
        for (int number = 0; number <= MAX_INT; number++) {
            int divisorsSum = 0;
            for (int index = number - 1; index > 0; index--) {
                if (number % index == 0) {
                    divisorsSum += index;
                }
            }
            if (divisorsSum > number) {
                ABUNDANT_NUMBERS.add(number);
            }
        }
    }
}
