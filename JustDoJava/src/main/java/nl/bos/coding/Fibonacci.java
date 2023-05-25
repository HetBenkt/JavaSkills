package nl.bos.coding;

public class Fibonacci {

    private static final String SPACE = " ";

    private Fibonacci() {}

    public static String run(int givenNumber) {
        if (givenNumber == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        int[] sequences = new int[]{0, 1, 0};
        result.append(sequences[0]).append(SPACE).append(sequences[1]).append(SPACE);
        do {
            sequences[2] = sequences[0] + sequences[1];
            if (sequences[2] > givenNumber) {
                break;
            }
            result.append(sequences[2]).append(SPACE);
            sequences[0] = sequences[1];
            sequences[1] = sequences[2];
        } while (sequences[2] < givenNumber);

        return String.valueOf(result).trim();
    }
}
