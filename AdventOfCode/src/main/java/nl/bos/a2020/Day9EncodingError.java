package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9EncodingError {

    public static final int PREAMBLE_SIZE = 25;

    public Day9EncodingError() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day9EncodingError");
        List<String> data = AdventReadInput.readData(is);

        int index = 0;
        List<Long> preamble = null;
        long theNumber = 0;

        while (index < data.size() - PREAMBLE_SIZE) {
            preamble = getNextPreamble(data, index, index + (PREAMBLE_SIZE - 1));
            theNumber = Long.parseLong(data.get(index + PREAMBLE_SIZE));
            if (!preampleHasSumOfTheNumber(preamble, theNumber)) {
                break;
            }
            index++;
        }

        System.out.println(String.format("theNumber= %d does not follow the rule on preamble: %s", theNumber, Arrays.toString(preamble.toArray())));
    }

    private boolean preampleHasSumOfTheNumber(List<Long> preamble, long theNumber) {
        for (int i = 0; i < preamble.size(); i++) {
            for (int j = i + 1; j < preamble.size(); j++) {
                if (preamble.get(i) + preamble.get(j) == theNumber)
                    return true;
            }
        }
        return false;
    }

    private List<Long> getNextPreamble(List<String> data, int start, int end) {
        List<Long> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(Long.parseLong(data.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        new Day9EncodingError();
    }
}
