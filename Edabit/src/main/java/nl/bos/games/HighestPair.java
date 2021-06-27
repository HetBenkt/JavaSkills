package nl.bos.games;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HighestPair {

    private final static Map<String, Integer> CARD_VALUES = new HashMap<>();

    static {
        CARD_VALUES.put("", 0);
        CARD_VALUES.put("1", 1);
        CARD_VALUES.put("2", 2);
        CARD_VALUES.put("3", 3);
        CARD_VALUES.put("4", 4);
        CARD_VALUES.put("5", 5);
        CARD_VALUES.put("6", 6);
        CARD_VALUES.put("7", 7);
        CARD_VALUES.put("8", 8);
        CARD_VALUES.put("9", 9);
        CARD_VALUES.put("J", 10);
        CARD_VALUES.put("Q", 11);
        CARD_VALUES.put("K", 12);
        CARD_VALUES.put("A", 13);
    }

    public static String highestPair(String[] arr) {
        String result = "";
        for (String character : arr) {
            long count = Arrays.stream(arr).filter(ch -> ch.equals(character)).count();
            if (count >= 2 && CARD_VALUES.get(character) > CARD_VALUES.get(result)) {
                result = character;
            }
        }
        return result;
    }
}
