package nl.bos.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StatementReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Statement:");
        String statement = br.readLine();
        System.out.println("The reverse is:");

        statement = reverse(statement);

        System.out.println(statement);
    }

    public static String reverse(String statement) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = statement.split(" ");
        for (String word : words) {
            stringBuilder.insert(0, String.format("%s ", word));
        }
        return String.valueOf(stringBuilder).trim();
    }
}
