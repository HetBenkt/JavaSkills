package nl.bos.projecteuler;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class AmicableNumbers {
    private static final int MAX_VALUE = 10000;
    private static final List<Integer> amicableList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < MAX_VALUE; i++) {
            int sumA = getProperDivisorsSum(i);
            if(i == sumA) {
                continue;
            }
            int sumB = getProperDivisorsSum(sumA);
            if (i == sumB) {
                amicableList.add(sumB);
            }
        }
        System.out.println(MessageFormat.format("Result {0}", amicableList.stream().mapToInt(e -> e).sum()));
    }

    private static int getProperDivisorsSum(int value) {
        int result = 0;
        for (int i = value - 1; i > 0; i--) {
            if (value % i == 0) {
                result += i;
            }
        }
        return result;
    }
}
