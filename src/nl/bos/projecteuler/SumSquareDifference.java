package nl.bos.projecteuler;

import lombok.extern.java.Log;

import java.text.MessageFormat;
import java.util.stream.IntStream;

@Log
public class SumSquareDifference {
    private static final int MAX_VALUE = 100;
    private static final int POW_VALUE = 2;

    public static void main(String[] args) {
        double sumOfSquares = calcSumOfSquares();
        double squareOfSum = calcSquareOfSum();

        log.info(MessageFormat.format("Result {0}", (int) (squareOfSum - sumOfSquares)));
    }

    private static double calcSquareOfSum() {
        int sum = IntStream.range(1, MAX_VALUE + 1).sum();
        return Math.pow(sum, POW_VALUE);
    }

    private static double calcSumOfSquares() {
        double result = 0;

        for (double i = 1; i <= MAX_VALUE; i++) {
            result += Math.pow(i, POW_VALUE);
        }

        return result;
    }
}
