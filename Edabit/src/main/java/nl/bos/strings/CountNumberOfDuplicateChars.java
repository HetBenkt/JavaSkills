package nl.bos.strings;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfDuplicateChars {
    public static int duplicateCount(String input) {
        int result = 0;
        for (Character character : getUniqueChars(input)) {
            if (input.chars().filter(value -> value == character).count() > 1) {
                result++;
            }
        }
        return result;
    }

    private static Set<Character> getUniqueChars(String input) {
        Set<Character> result = new HashSet<>();
        for (char character : input.toCharArray()) {
            result.add(character);
        }
        return result;
    }
}
