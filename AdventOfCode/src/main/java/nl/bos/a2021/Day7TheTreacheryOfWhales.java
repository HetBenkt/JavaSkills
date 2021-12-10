package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day7TheTreacheryOfWhales {

    public Day7TheTreacheryOfWhales() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day7TheTreacheryOfWhales");
        List<Integer> horizontalPositions = Arrays.stream(AdventReadInput.readData(is).get(0).split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        //todo

        System.out.printf("Fluel spend: %s", 0);
    }

    public static void main(String[] args) {
        new Day7TheTreacheryOfWhales();
    }
}