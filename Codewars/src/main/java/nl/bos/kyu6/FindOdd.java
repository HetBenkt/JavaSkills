package nl.bos.kyu6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FindOdd {
    private FindOdd() {
    }

    static int findIt(int[] a) {
        int[] uniqueValues = Arrays.stream(a).distinct().toArray();

        for (int uniqueValue : uniqueValues) {
            if (isOdd(a, uniqueValue))
                return uniqueValue;
        }
        return 0;
    }

    private static boolean isOdd(int[] a, int uniqueValue) {
        List<Integer> integerList = IntStream.of(a).boxed().collect(Collectors.toList());
        int count = Collections.frequency(integerList, uniqueValue);
        return count % 2 != 0;
    }
}
