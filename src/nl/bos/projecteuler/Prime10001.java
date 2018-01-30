package nl.bos.projecteuler;

import lombok.extern.java.Log;

import java.text.MessageFormat;

@Log
public class Prime10001 {
    private static int value = 2;

    public static void main(String[] args) {
        int primeValue = 0;
        int inputValue = 10001;
        for (int i = 0; i < inputValue; i++) {
            primeValue = getNextPrimeNumber();
            value++;
        }
        log.info(MessageFormat.format("Prime value {0}", primeValue));
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
