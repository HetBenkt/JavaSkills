package nl.bos.strings;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberWordDecoder {
    private static final Map<String, Integer> decoder = new HashMap<>();

    static {
        decoder.put("A", 2);
        decoder.put("B", 2);
        decoder.put("C", 2);
        decoder.put("D", 3);
        decoder.put("E", 3);
        decoder.put("F", 3);
        decoder.put("G", 4);
        decoder.put("H", 4);
        decoder.put("I", 4);
        decoder.put("J", 5);
        decoder.put("K", 5);
        decoder.put("L", 5);
        decoder.put("M", 6);
        decoder.put("N", 6);
        decoder.put("O", 6);
        decoder.put("P", 7);
        decoder.put("Q", 7);
        decoder.put("R", 7);
        decoder.put("S", 7);
        decoder.put("T", 8);
        decoder.put("U", 8);
        decoder.put("V", 8);
        decoder.put("W", 9);
        decoder.put("X", 9);
        decoder.put("Y", 9);
        decoder.put("Z", 9);
    }

    public static String textToNum(String phone) {
        StringBuilder result = new StringBuilder();

        for (char value : phone.toCharArray()) {
            if (Character.isAlphabetic(value)) {
                result.append(decoder.get(String.valueOf(value)));
            } else {
                result.append(value);
            }
        }

        return String.valueOf(result);
    }
}
