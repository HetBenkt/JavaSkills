package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day10AdapterArray {

    public Day10AdapterArray() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day10AdapterArray");
        List<String> data = AdventReadInput.readData(is);

        List<Integer> integers = data.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Collections.sort(integers);

        int previousValue = 0;
        int oneJoltDifferences = 0;
        int threeJoltDifferences = 1; //Start with 1 for your own built-in joltage adapter!
        for (int value : integers) {
            if (value - previousValue == 1) {
                oneJoltDifferences++;
            }
            if (value - previousValue == 3) {
                threeJoltDifferences++;
            }
            previousValue = value;
        }

        System.out.print(String.format("%d * %d = %d", oneJoltDifferences, threeJoltDifferences, oneJoltDifferences * threeJoltDifferences));
    }

    public static void main(String[] args) {
        new Day10AdapterArray();
    }
}
