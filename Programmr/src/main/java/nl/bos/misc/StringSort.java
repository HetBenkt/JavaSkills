package nl.bos.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringSort {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a string:\n");
        String input = br.readLine();

        System.out.println("Sorted string:\n" + sort(input));
    }

    public static String sort(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
