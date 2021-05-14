package nl.bos.misc;

import java.util.Scanner;

public class IsBinaryOrNot {

    public static void main(String[] args) {
        System.out.println("Enter a number:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (isBinary(num)) {
            System.out.println("Binary");
        } else {
            System.out.println("Not Binary");
        }
    }

    public static boolean isBinary(int num) {
        String input = "" + num;
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }
}
