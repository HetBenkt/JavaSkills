package nl.bos.misc;

import java.util.Scanner;

public class DecimalToOctalConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();

        System.out.printf("Octal number is: %s", convert(num));
    }

    public static int convert(int input) {
        return Integer.parseInt(Integer.toOctalString(input));
    }
}
