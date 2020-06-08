package nl.bos.kyu5;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> result = new ArrayList<>();

        List<T> temp = new ArrayList<>();
        temp.addAll(items);
        for (int i = 1; i < k * 6; i++) {
            items.addAll(temp);
        }

        int index = 1;
        for (int i = 1; i <= items.size(); i++) {
            T t = items.get(i - 1);
            if (index % k == 0 && !result.contains(t)) {
                result.add(t);
                index++;
            } else {
                if (!result.contains(t)) {
                    index++;
                }
            }
        }

        return result;
    }
}
