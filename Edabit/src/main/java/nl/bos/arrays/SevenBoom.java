package nl.bos.arrays;

public class SevenBoom {
    public final static String BOOM = "Boom!";
    public final static String NO_SEVEN = "there is no 7 in the array";

    public static String sevenBoom(int[] arr) {
        for (int number : arr) {
            if (String.valueOf(number).contains("7")) {
                return BOOM;
            }
        }
        return NO_SEVEN;
    }
}
