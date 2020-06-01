package nl.bos.kyu5;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> result = new ArrayList<>();

        List<T> temp = new ArrayList<>();
        temp.addAll(items);
        for (int i = 1; i < k; i++) {
            items.addAll(temp);
        }

        int leftOver = 0;
        int extra = 0;
        while (items.size() / k != 1 && items.size() > 0) {
            int offset = leftOver;
            if (items.size() / k < k) {
                extra = k - items.size() / k;
            }
            for (int i = 1; i <= (items.size() / k) + extra; i++) {
                if ((i + offset) % k == 0) {
                    result.add(items.get(i - 1));
                    leftOver = items.size() / k - i;
                }
            }
            items.removeAll(result);
            if (items.isEmpty())
                break;
        }
        if (items.size() == k) {
            result.add(items.get(0));
        }
        return result;
    }
}
