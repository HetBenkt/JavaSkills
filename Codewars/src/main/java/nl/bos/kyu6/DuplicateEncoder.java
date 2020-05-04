package nl.bos.kyu6;

public class DuplicateEncoder {
    static String encode(String word){
        StringBuilder result = new StringBuilder();
        String[] characters = word.toUpperCase().split("");
        for (String character: characters) {
            result.append(isCharacterDuplicateInString(character, word) ? ")" : "(");
        }
        return String.valueOf(result);
    }

    private static boolean isCharacterDuplicateInString(String character, String word) {
        long count = word.toUpperCase().chars().filter(ch -> ch == character.toCharArray()[0]).count();
        return count > 1;
    }
}
