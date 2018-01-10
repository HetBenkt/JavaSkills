package nl.bos.projecteuler;

import java.math.BigInteger;

public class LargestPrimeFactor {
    private static long input_value = 600851475143L;
    private static int value = 2;

    public static void main(String[] args) {
        int primeValue;
        do {
            primeValue = getNextPrimeNumber();
            if(input_value % primeValue == 0) {
                input_value = input_value/primeValue;
                System.out.println(primeValue);
            }
            value++;
        } while (input_value != 1);
    }

    private static int getNextPrimeNumber() {
        while (!isPrimeNumber()) {
            value++;
        }
        return value;
    }

    private static boolean isPrimeNumber() {
        for (int i = 2; i < value; i++) {
            if (value % i == 0)
                return false;
        }
        return true;
    }
}
