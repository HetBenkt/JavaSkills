package nl.bos.strings;

public class UnmixMyStrings {
    public static String unmix(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2) {
            char char1 = chars[i];
            try {
                char char2 = chars[i + 1];
                chars[i + 1] = char1;
                chars[i] = char2;
            } catch (ArrayIndexOutOfBoundsException e) {
                return String.valueOf(chars);
            }
        }
        return String.valueOf(chars);
    }
}
