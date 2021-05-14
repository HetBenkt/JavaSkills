package nl.bos.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromeString {
    public static void main(String[] args) throws Exception {
        boolean isCorrect = false;
        System.out.println("Enter the string:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println("Result string is:");

        if (isPalindrome(input)) {
            System.out.print("palindrome");
        } else {
            System.out.print("not a palindrome");
        }
    }

    public static boolean isPalindrome(String input) {
        char[] chars = input.toCharArray();
        int startIndex = 0;
        int endIndex = chars.length - 1;
        while (chars[startIndex] == chars[endIndex]) {
            startIndex++;
            endIndex--;
            if (startIndex >= endIndex) {
                return true;
            }
        }
        return false;
    }
}