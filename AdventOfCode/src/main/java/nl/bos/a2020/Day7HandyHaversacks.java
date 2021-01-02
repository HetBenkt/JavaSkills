package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day7HandyHaversacks {

    public Day7HandyHaversacks() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day7HandyHaversacks");
        List<String> data = AdventReadInput.readData(is);


    }

    public static void main(String[] args) {
        new Day7HandyHaversacks();
    }
}
