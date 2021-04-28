package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day17ConwayCubes {

    public Day17ConwayCubes() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day17ConwayCubes");
        List<String> data = AdventReadInput.readData(is);

        //todo

        System.out.printf("# of cubes left in the active state after the sixth cycle = %d%n", 0);
    }
}