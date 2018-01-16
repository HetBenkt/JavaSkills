package nl.bos.projecteuler;

import java.util.stream.IntStream;

public class SumSquareDifference {
    public static final int MAX_VALUE = 100;
    public static final int POW_VALUE = 2;

    public static void main(String[] args) {
        double sumOfSquares = calcSumOfSquares();
        double squareOfSum = calcSquareOfSum();

        System.out.println((int) (squareOfSum - sumOfSquares));
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
