package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;

public class Day6Lanternfish {

    public Day6Lanternfish() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day6Lanternfish");
        String[] lanternFishTimers = AdventReadInput.readData(is).get(0).split(",");

        System.out.printf("# lanternfish after 80 days: %s", 0);
    }

    public static void main(String[] args) {
        new Day6Lanternfish();
    }
}