package nl.bos.hackerearth.implementation;

/*
  https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/chocolates-boxes-1/
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * No package structure! Main throws an Exception
 */
public class ChocolatesAndBoxes {

    private static final String DELIM = " ";

    public static void main(String args[]) throws Exception {
        //Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File("input.txt"));
        int nrTestCases = s.nextInt();
        s.nextLine(); // = Carriage return <Enter>

        for (int i = 0; i < nrTestCases; i++) {
            int nrBoxes = s.nextInt();
            s.nextLine(); // = Carriage return <Enter>
            String boxValues = s.nextLine();
            int nrChocolades = s.nextInt();
            System.out.println(printNrOfWays(toIntArray(nrBoxes, boxValues), nrChocolades));
        }
        s.close();
    }

    private static int[] toIntArray(int nrBoxes, String boxValues) {
        int[] result = new int[nrBoxes];
        StringTokenizer tokenizer = new StringTokenizer(boxValues, DELIM);
        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            String value = tokenizer.nextToken();
            result[index] = Integer.parseInt(value);
            index++;
        }
        return result;
    }

    private static int printNrOfWays(int[] boxValues, int nrChocolades) {
        int result = 0;
        for (int i = 0; i < boxValues.length; i++) {
            for (int j = i; j < boxValues.length; j++) {
                if(i != j) {
                    if(boxValues[i] + boxValues[j] == nrChocolades) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}