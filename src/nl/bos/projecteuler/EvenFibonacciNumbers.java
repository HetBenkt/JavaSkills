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
        List<Integer> evenValues = new ArrayList<Integer>();

        int value1 = START_VALUE_1;
        int value2 = START_VALUE_2;
        int term;

        evenValues.add(new Integer(value2));

        while((value1 + value2) <= MAX_VALUE) {
            term = value1 + value2;
            if( term % 2 == 0 ) {
                evenValues.add(new Integer(term));
            }
            value1 = value2;
            value2 = term;
        }

        System.out.println(evenValues.stream().mapToInt(e -> e.intValue()).sum());
    }
}