package nl.bos.misc;

import java.util.Scanner;

public class SumOfNaturalsDivisibleBy3And5 {

    public static void main(String[] args) {
        System.out.println("Enter the maximum no:");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.printf("Total is: %s", sum(input));
    }

    public static int sumOld(int input) {
        int sum = 0;
        for (int i = 1; i < input; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
            if (i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int sum(int input) {
        input = input - 1;
        //Sum of natural numbers = n*(n+1)/2
        int a = 3 * ((input / 3) * (input / 3 + 1) / 2);
        int b = 5 * ((input / 5) * (input / 5 + 1) / 2);
        int c = 15 * ((input / 15) * (input / 15 + 1) / 2);

        return (a + b) - c;
    }
}