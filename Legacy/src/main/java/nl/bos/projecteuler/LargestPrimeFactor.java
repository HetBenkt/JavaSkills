package nl.bos.projecteuler;

import lombok.extern.java.Log;

import java.text.MessageFormat;

@Log
public class LargestPrimeFactor {
    private static long inputValue = 600851475143L;
    private static int value = 2;

    public static void main(String[] args) {
        int primeValue;
        do {
            primeValue = getNextPrimeNumber();
            if(inputValue % primeValue == 0) {
                inputValue = inputValue /primeValue;
                log.info(MessageFormat.format("Prime value {0}", primeValue));
            }
            value++;
        } while (inputValue != 1);
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
