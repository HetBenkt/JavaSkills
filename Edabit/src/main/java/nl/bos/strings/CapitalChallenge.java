package nl.bos.strings;

public class CapitalChallenge {
    public static String selectLetters(String s1, String s2) {
        String output1 = pickLetter(s1, s2);
        String output2 = pickLetter(s2, s1);
        return output1 + output2;
    }

    private static String pickLetter(String input1, String input2) {
        StringBuilder result = new StringBuilder();
        char[] chars = input1.toCharArray();
        int index = 0;
        for (char character : input2.toCharArray()) {
            if (Character.isUpperCase(character) && index != chars.length) {
                result.append(chars[index]);
            }
            index++;
        }
        return String.valueOf(result);
    }
}
