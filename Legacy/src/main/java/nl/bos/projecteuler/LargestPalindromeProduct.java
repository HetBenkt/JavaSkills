package nl.bos.projecteuler;

import java.text.MessageFormat;

public class LargestPalindromeProduct {
    private static final int START_DIGIT_1 = 999;
    private static final int START_DIGITAL_2 = 999;

    private static int digit1 = START_DIGIT_1;
    private static int digit2 = START_DIGITAL_2;

    private static int highestProduct = 0;

    public static void main(String[] args) {
        int product = digit1 * digit2;
        while (!isPalindrome(product) || digit2 != 0) {
            digit1--;
            if (digit1 == 0) {
                digit1 = START_DIGIT_1;
                digit2--;
            }

            if (isPalindrome(product)) {
                System.out.println(MessageFormat.format("Product {0}", product));
                if (highestProduct < product)
                    highestProduct = product;
            }

            product = digit1 * digit2;
        }
        System.out.println(MessageFormat.format("Result {0}", highestProduct));
    }

    private static boolean isPalindrome(int product) {
        boolean result = false;

        char[] chars = String.valueOf(product).toCharArray();
        switch (chars.length) {
            case 1:
                if (chars[0] == chars[chars.length - 1])
                    result = true;
                break;
            case 2:
                if (chars[0] == chars[chars.length - 1] && chars[1] == chars[chars.length - 2])
                    result = true;
                break;
            default:
                if (chars[0] == chars[chars.length - 1] && chars[1] == chars[chars.length - 2] && chars[2] == chars[chars.length - 3])
                    result = true;
                break;
        }
        return result;
    }
}
