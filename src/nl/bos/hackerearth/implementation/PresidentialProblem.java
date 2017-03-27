package nl.bos.hackerearth.implementation;

/*
  https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/presidential-problem/
 */

import java.io.File;
import java.util.*;

public class PresidentialProblem {

    private static final String DELIM = " ";

    public static void main(String args[]) throws Exception {
        //Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File("input.txt"));
        int nrTestCases = s.nextInt();
        s.nextLine(); // = Carriage return <Enter>

        for (int i = 0; i < nrTestCases; i++) {
            StringTokenizer queries = new StringTokenizer(s.nextLine(), DELIM);
            int nrQueries = Integer.parseInt(queries.nextElement().toString());
            String text = s.nextLine();

            int[][] values = revalidateInput(s, nrQueries);
            for (int j = 0; j < nrQueries; j++) {
                text = shiftToThePreviousAlphabet(text, values[j][0]-1, values[j][1]);
            }
            System.out.println(text.substring(0, text.length()-1)); //BUG as input lenght is different from output lenght in test-case!
        }
        s.close();
    }

    private static String shiftToThePreviousAlphabet(String text, int nrL, int nrR) {

        StringBuilder result = new StringBuilder();
        char[] chars = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if(i >= nrL && i <nrR) {
                char c = chars[i];
                c--;
                if(c == 96) //a
                    c = 122; //z
                chars[i] = c;
            }
            result.append(chars[i]);
        }
        return result.toString();
    }

    private static int[][] revalidateInput(Scanner s, int nrQueries){
        int[][] result = new int[nrQueries][2];
        for (int j = nrQueries-1; j >= 0; j--) {
            StringTokenizer valuesLR = new StringTokenizer(s.nextLine(), DELIM);
            int nrL = Integer.parseInt(valuesLR.nextElement().toString());
            int nrR = Integer.parseInt(valuesLR.nextElement().toString());
            result[j][0] = nrL;
            result[j][1] = nrR;
        }
        return result;
    }
}