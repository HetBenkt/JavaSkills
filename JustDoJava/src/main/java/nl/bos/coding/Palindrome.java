package nl.bos.coding;

public class Palindrome {

    private Palindrome() {
    }

    public static boolean run(String givenText) {
        char[] textArray = givenText.toLowerCase().toCharArray();
        for (int i = 0; i < textArray.length / 2; i++) {
            if (textArray[i] != textArray[textArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
