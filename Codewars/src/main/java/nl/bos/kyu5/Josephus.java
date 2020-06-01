package nl.bos.kyu5;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> result = new ArrayList<>();

        int leftOver = 0;

        while (result.size() != items.size()) {
            int offset = leftOver;

            items.removeAll(result);
            if (items.size() == 1) {
                result.addAll(items);
                break;
            }

            for (int i = 1; i <= items.size(); i++) {
                if ((i + offset) % k == 0) {
                    result.add(items.get(i - 1));
                    leftOver = items.size() - i;
                }
            }
        }

        return result;
    }
}
