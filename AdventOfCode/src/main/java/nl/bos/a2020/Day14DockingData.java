package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day14DockingData {

    public Day14DockingData() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day14DockingData");
        List<String> data = AdventReadInput.readData(is);

        //TODO

        System.out.println(String.format("The sum of all values left in memory after it completes = %d", 0));
    }

    public static void main(String[] args) {
        new Day14DockingData();
    }
}