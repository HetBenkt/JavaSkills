package nl.bos.hackerearth.input_output;

/*
  https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/count-numbers-46/
 */

import java.io.File;
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class CountNumbers {

    public static void main(String args[]) throws Exception {
        //Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File("input.txt"));
        int nrTestCases = s.nextInt();
        s.nextLine(); // = Carriage return <Enter>

        for (int i = 0; i < nrTestCases; i++) {
            int textLenght = s.nextInt();
            s.nextLine(); // = Carriage return <Enter>
            String text = s.nextLine();
            text = text.replaceAll("[^-?0-9]+", " ");
            System.out.println(text.trim().split(" ").length);
        }
        s.close();
    }
}