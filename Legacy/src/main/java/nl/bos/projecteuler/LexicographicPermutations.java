package nl.bos.projecteuler;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class LexicographicPermutations {
    @Test
    void execute() {
        List<Integer> values = Lists.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        Collection<List<Integer>> orderPerm =
                Collections2.orderedPermutations(values);

        int index = 1;
        for (List<Integer> val : orderPerm) {
            if(index == 1000000)
                System.out.println(val);
            index++;
        }
    }
}
