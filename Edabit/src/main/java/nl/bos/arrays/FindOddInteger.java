package nl.bos.arrays;

import java.util.Arrays;

public class FindOddInteger {
    public static int findOdd(int[] ints) {
        for (int i : ints) {
            long count = Arrays.stream(ints).filter(value -> value == i).count();
            if (count % 2 == 1) {
                return i;
            }
        }

        return 0;
    }
}
