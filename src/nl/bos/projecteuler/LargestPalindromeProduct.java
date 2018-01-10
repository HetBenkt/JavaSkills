package nl.bos.projecteuler;

public class LargestPalindromeProduct {
    public static final int START_DIGIT_1 = 999;
    public static final int START_DIGITAL_2 = 999;

    public static int digit1 = START_DIGIT_1;
    public static int digit2 = START_DIGITAL_2;

    public static int highestProduct = 0;

    public static void main(String[] args) {
        int product = digit1 * digit2;
        while (!isPalindrome(product) || digit2 != 0) {
            digit1--;
            if (digit1 == 0) {
                digit1 = START_DIGIT_1;
                digit2--;
            }

            if (isPalindrome(product)) {
                System.out.println(product);
                if (highestProduct < product)
                    highestProduct = product;
            }

            product = digit1 * digit2;
        }
        System.out.println("Result: " + highestProduct);
    }

    private static boolean isPalindrome(int product) {
        boolean result = false;

        char[] chars = String.valueOf(product).toCharArray();
        if (chars.length == 1) {
            if (chars[0] == chars[chars.length - 1])
                result = true;
        } else if (chars.length == 2) {
            if (chars[0] == chars[chars.length - 1] && chars[1] == chars[chars.length - 2])
                result = true;
        } else {
            if (chars[0] == chars[chars.length - 1] && chars[1] == chars[chars.length - 2] && chars[2] == chars[chars.length - 3])
                result = true;
        }
        return result;
    }
}
