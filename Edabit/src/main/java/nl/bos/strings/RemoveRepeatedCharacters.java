package nl.bos.strings;

public class RemoveRepeatedCharacters {
    public static String unrepeated(String input) {
        StringBuilder output = new StringBuilder();

        for (char character : input.toCharArray()) {
            if (!output.toString().contains("" + character)) {
                output.append(character);
            }
            input = input.substring(1);
        }

        return output.toString();
    }
}
