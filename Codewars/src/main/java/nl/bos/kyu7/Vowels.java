package nl.bos.kyu7;

class Vowels {
    private static final String VOWELS_CHARS = "aeiou";

    private Vowels() {
    }

    static int getCount(String str) {
        int result = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (isVowel(c)) {
                result++;
            }
        }
        return result;
    }

    private static boolean isVowel(char c) {
        return VOWELS_CHARS.contains(String.valueOf(c));
    }
}
