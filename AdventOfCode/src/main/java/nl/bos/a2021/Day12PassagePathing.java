package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day12PassagePathing {

    public Day12PassagePathing() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day12PassagePathing");
        List<String> caves = AdventReadInput.readData(is);

        //todo

        System.out.printf("Total of paths through this cave system that visit small caves at most once: %s", 0);
    }

    public static void main(String[] args) {
        new Day12PassagePathing();
    }
}