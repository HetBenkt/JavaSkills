package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day8HandheldHalting {

    public Day8HandheldHalting() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day8HandheldHalting");
        List<String> data = AdventReadInput.readData(is);

        System.out.println(String.format("%d individual bags are required inside the single shiny gold bag!", 0));
    }

    public static void main(String[] args) {
        new Day8HandheldHalting();
    }
}
