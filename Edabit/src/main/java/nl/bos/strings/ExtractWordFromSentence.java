package nl.bos.strings;

public class ExtractWordFromSentence {
    public static String removeWord(String sentence, String removalWord) {
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();

        int index = 1;
        for (String word : words) {
            if (!word.equals(removalWord)) {
                builder.append(word);
                if (words.length > index) {
                    builder.append(" ");
                }
            }
            index++;
        }
        return builder.toString();
    }
}
