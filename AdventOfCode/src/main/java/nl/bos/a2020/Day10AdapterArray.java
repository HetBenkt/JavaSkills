package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day10AdapterArray {

    public Day10AdapterArray() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day10AdapterArray");
        List<String> data = AdventReadInput.readData(is);

        //TODO
    }

    public static void main(String[] args) {
        new Day10AdapterArray();
    }
}
