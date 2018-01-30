package nl.bos.projecteuler;

import java.util.stream.IntStream;

public class SummationOfPrimes {
    private final static long MAX = 2000000L;

    public static void main(String[] args) {
        long sum = 2L;
        for (int i = 0; i < MAX; i++) {
            if (isPrimeValue(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static boolean isPrimeValue(int number) {
        return number > 2
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }
}
