package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9EncodingError {

    public static final long INVALID_NUMBER = 167829540;

    public Day9EncodingError() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day9EncodingError");
        List<String> data = AdventReadInput.readData(is);

        int index = 0;
        long sum = 0;
        int overallIndex = 0;
        List<Long> contiguousSet = new ArrayList<>();

        while (index < data.size()) {
            long number = Long.parseLong(data.get(index));
            contiguousSet.add(number);
            sum += number;
            if (sum >= INVALID_NUMBER) {
                if (sum == INVALID_NUMBER) {
                    Long max = Collections.max(contiguousSet);
                    Long min = Collections.min(contiguousSet);
                    System.out.println(String.format("Sum of %d and %d is %d", min, max, max + min));
                    System.exit(-1);
                }
                sum = 0;
                contiguousSet.clear();
                index = ++overallIndex;
                continue;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        new Day9EncodingError();
    }
}
