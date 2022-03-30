package nl.bos.projecteuler;

import java.text.MessageFormat;

public class HighlyDivisibleTriangularNumber {
    public static void main(String[] args) {
        long sum = 1L;
        int divisors;
        int index = 0;
        while (true) {
            sum += index;
            divisors = calcDivisors(sum - 1);

            if (index % 1000 == 0) {
                System.out.println(MessageFormat.format("Triangle nr. {0} is {1} and has {2} divisors.", index, sum - 1, divisors));
            }
            if (divisors >= 500) {
                System.out.println(MessageFormat.format("Triangle nr. {0} is {1} and has {2} divisors.", index, sum - 1, divisors));
                return;
            }
            index++;
        }
    }

    private static int calcDivisors(long value) {
        int result = 0;
        for (long i = value - 1; i >= 1; i--) {
            if (value % i == 0)
                result++;
        }
        return result;
    }
}
