package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day12RainRisk {

    public Day12RainRisk() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day12RainRisk");
        List<String> data = AdventReadInput.readData(is);

        //TODO

        System.out.println(String.format("The Manhattan distance = %d", 0));
    }

    public static void main(String[] args) {
        new Day12RainRisk();
    }

}