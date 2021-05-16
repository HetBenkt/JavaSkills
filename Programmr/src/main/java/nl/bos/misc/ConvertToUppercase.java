package nl.bos.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertToUppercase {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string:");
        String input = br.readLine();

        System.out.println("Uppercase conversion:");
        System.out.println(input.toUpperCase());
    }
}
