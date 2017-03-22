package nl.bos.hackerearth.implementation;

/*
  https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/chocolates-boxes-1/
 */

import java.io.File;
import java.util.*;

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
            int nrChocolates = s.nextInt();
            System.out.println(printNrOfWays(toIntArray(nrBoxes, boxValues), nrChocolates));
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
        Arrays.sort(result);
        return result;
    }

    private static int printNrOfWays(int[] boxValues, int nrChocolates) {
        int result = 0;
        Map<Integer, Integer> occurrences = countOccurrence(boxValues);

        for (int i = boxValues.length - 1; i >= 0; i--) {
            int occurrence;
            if (occurrences.containsKey(nrChocolates - boxValues[i])) {
                occurrence = occurrences.get(nrChocolates - boxValues[i]);
                if (nrChocolates - boxValues[i] == boxValues[i])
                    occurrence--;
                result += occurrence;

                int key = boxValues[i];
                int value = occurrences.get(key);
                if (value - 1 == 0)
                    occurrences.remove(key);
                else
                    occurrences.put(key, value - 1);
            }
        }
        return result;
    }

    private static Map<Integer, Integer> countOccurrence(int[] numbersToProcess) {
        int[] possibleNumbers = new int[numbersToProcess[numbersToProcess.length - 1] * 2];
        Map<Integer, Integer> result = new HashMap<>();

        for (int number : numbersToProcess) {
            possibleNumbers[number] = possibleNumbers[number] + 1;
            result.put(number, possibleNumbers[number]);
        }

        return result;
    }
}