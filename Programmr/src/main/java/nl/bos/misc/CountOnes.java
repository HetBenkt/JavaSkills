package nl.bos.misc;

import java.util.Scanner;

public class CountOnes {

    public static void main(String[] args) {
        System.out.println("Enter the Maximum value:");
        Scanner sc1 = new Scanner(System.in);
        long max = sc1.nextLong();
        System.out.println("Total sum of count of 1s: ");
        System.out.println(count(1, max));
    }

    public static long count(int minInput, long maxInput) {
        long result = 0;
        for (int i = minInput; i <= maxInput; i++) {
            int count = 0;
            String someString = String.valueOf(i);
            for (int j = 0; j < someString.length(); j++) {
                if (someString.charAt(j) == '1') {
                    count++;
                }
            }
            result += count;
        }
        return result;
    }
}
