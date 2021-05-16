package nl.bos.misc;

import java.util.Scanner;

public class NumberToStringFormat {

    private final static String[] ONES = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen"};
    private final static String[] TENS = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninty"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number:");
        int num = sc.nextInt();
        System.out.println("Entered number is:");

        String format = numberToString(num);

        System.out.println(format);
    }

    public static String numberToString(int num) {
        if (num < 20) {
            return ONES[num - 1];
        } else {
            char[] chars = String.format("%d", num).toCharArray();
            String ten = TENS[Integer.parseInt(String.valueOf(chars[0])) - 2];
            if (chars[1] != '0') {
                String one = ONES[Integer.parseInt(String.valueOf(chars[1])) - 1];
                return String.format("%s %s", ten, one);
            }
            return ten;
        }
    }
}
