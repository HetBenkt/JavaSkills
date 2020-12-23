package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day5BinaryBoarding {

    public Day5BinaryBoarding() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day5BinaryBoarding");
        List<String> data = AdventReadInput.readData(is);


    }

    public static void main(String[] args) {
        new Day5BinaryBoarding();
    }
}
