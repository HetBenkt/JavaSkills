package nl.bos.projecteuler;

import lombok.extern.java.Log;

import java.text.MessageFormat;

/**
 * Created by bosa on 28-11-2017.
 */
@Log
public class EvenFibonacciNumbers {
    private static final int MAX_VALUE = 4000000;
    private static final int START_VALUE_1 = 1;
    private static final int START_VALUE_2 = 2;

    public static void main(String[] args) {
        int evenValues = 2;

        int value1 = START_VALUE_1;
        int value2 = START_VALUE_2;
        int term;

        while((value1 + value2) <= MAX_VALUE) {
            term = value1 + value2;
            if( term % 2 == 0 ) {
                evenValues += term;
            }
            value1 = value2;
            value2 = term;
        }

        log.info(MessageFormat.format("Even values {0}", evenValues));
    }
}