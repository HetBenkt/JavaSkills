package nl.bos.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bosa on 28-11-2017.
 */
public class EvenFibonacciNumbers {
    public static final int MAX_VALUE = 4000000;
    public static final int START_VALUE_1 = 1;
    public static final int START_VALUE_2 = 2;

    public static void main(String[] args) {
        int evenValues = 2;

        int value1 = START_VALUE_1;
        int value2 = START_VALUE_2;
        int term = 0;

        while((value1 + value2) <= MAX_VALUE) {
            term = value1 + value2;
            if( term % 2 == 0 ) {
                evenValues += term;
            }
            value1 = value2;
            value2 = term;
        }

        System.out.println(evenValues);
    }
}