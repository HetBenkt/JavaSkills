package nl.bos.kyu6;

import java.util.HashMap;
import java.util.Map;

class MorseCode {
    private static Map<String, String> morseMap = new HashMap<>();

    private MorseCode() {
        morseMap.put("....", "H");
        morseMap.put(".", "E");
        morseMap.put("-.--", "Y");
        morseMap.put(".---", "J");
        morseMap.put("..-", "U");
        morseMap.put("-..", "D");
    }

    static String get(String letterCode) {
        new MorseCode();
        return morseMap.get(letterCode);

    }
}
