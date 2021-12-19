package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day9SmokeBasin {

    public Day9SmokeBasin() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day9SmokeBasin");
        List<String> data = AdventReadInput.readData(is);

        System.out.printf("The sum of the risk levels of all low points on the heightmap: %s", 0);
    }

    public static void main(String[] args) {
        new Day9SmokeBasin();
    }
}