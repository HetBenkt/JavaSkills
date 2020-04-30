package nl.bos.kyu6;

import java.util.Arrays;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        int result = 0;

        String[] uniqueChars = Arrays.stream(text.toUpperCase().split("")).distinct().toArray(String[]::new);

        for (String uniqueChar: uniqueChars) {
            long count = text.toUpperCase().chars().filter(ch -> ch == uniqueChar.toCharArray()[0]).count();
            if(count > 1) {
                result++;
            }
        }

        return result;
    }
}
