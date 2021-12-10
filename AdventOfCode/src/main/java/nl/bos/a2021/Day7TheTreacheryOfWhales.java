package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day7TheTreacheryOfWhales {

    public Day7TheTreacheryOfWhales() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day7TheTreacheryOfWhales");
        List<Integer> horizontalPositions = Arrays.stream(AdventReadInput.readData(is).get(0).split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int fuelSpend = Integer.MAX_VALUE;
        int index = 0;
        while (index < Collections.max(horizontalPositions)) {
            int finalIndex = index;
            Integer sum = horizontalPositions.stream().map(integer -> {
                integer = integer - finalIndex;
                return Math.abs(integer);
            }).mapToInt(Integer::intValue).sum();

            if (sum < fuelSpend) {
                fuelSpend = sum;
            }
            index++;
        }

        System.out.printf("Fuel spend: %s", fuelSpend);
    }

    public static void main(String[] args) {
        new Day7TheTreacheryOfWhales();
    }
}