package nl.bos.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfTheDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the date(ddmmyy):");
        String date = br.readLine();

        int number = getLuckyNumber(date);

        System.out.println("Your lucky number is:");
        System.out.println(number);

    }

    public static int getLuckyNumber(String date) {
        char[] chars = date.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        if (sum > 9) {
            return getLuckyNumber(String.valueOf(sum));
        }
        return sum;
    }
}
