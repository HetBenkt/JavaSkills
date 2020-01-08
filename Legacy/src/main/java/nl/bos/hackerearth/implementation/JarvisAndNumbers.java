package nl.bos.hackerearth.implementation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
  https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/jarvis-and-numbers-1/
 */

/**
 * No package structure! Main throws an Exception
 */

/*
 *
5
base2 101 = 2
base3 12  = 3
base4 11  = 2
7/3
-> 3

7
base2 111 = 3
base3 21  = 3
base4 13  = 4
base5 12  = 3
base6 11  = 2
15/5 = 3/1
-> 1
 */
public class JarvisAndNumbers {
    private final static int START_BASE = 2;

    public static void main(String args[]) throws Exception {
        //Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File("input.txt"));
        int nrTestCases = s.nextInt();
        s.nextLine(); // = Carriage return <Enter>

        for (int i = 0; i < nrTestCases; i++) {
            int number = s.nextInt();
            System.out.println(findDenominatorOfAverage(number));
        }
        s.close();
    }

    private static int findDenominatorOfAverage(int number) {
        int totalValue = 0;

        for (int base = START_BASE; base < number; base++) {
            List<Integer> values = convertBase(number, base);
            int subValue = 0;
            for (Integer value : values) {
                subValue += value;
            }
            totalValue += subValue;
        }
        return (number - START_BASE) / findLastDivider(totalValue, number - START_BASE);
    }

    private static List<Integer> convertBase(int number, int radix) {

        List<Integer> remainder = new ArrayList<>();

        int count = 0;
        while (number != 0) {
            remainder.add(count, number % radix != 0 ? number % radix : 0);
            number /= radix;
        }
        return remainder;
    }

    private static int findLastDivider(int totalValue, int divider) {
        if (divider == 0) {
            return totalValue;
        }
        return findLastDivider(divider, totalValue % divider);
    }
}
