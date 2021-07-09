package nl.bos.arrays;

import java.util.Arrays;

public class ConsecutiveNumbers {
    public static boolean cons(int[] arr) {
        Arrays.sort(arr);

        int index = arr[0];
        for (int number : arr) {
            if (number != index) {
                return false;
            }
            index++;
        }
        return true;
    }
}
