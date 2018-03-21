package nl.bos.projecteuler;

import lombok.extern.java.Log;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Log
public class AmicableNumbers {
    private static final int MAX_VALUE = 10000;
    private static final List<Integer> amicableList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < MAX_VALUE; i++) {
            int sumA = getProperDivisorsSum(i);
            int sumB = getProperDivisorsSum(sumA);
            if (i == sumB && sumA != sumB) {
                amicableList.add(sumA);
                amicableList.add(sumB);
            }
        }
        log.info(MessageFormat.format("Result {0}", amicableList.stream().mapToInt(e -> e).distinct().sum()));
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
