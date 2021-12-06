package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day5HydrothermalVenture {

    public Day5HydrothermalVenture() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day5HydrothermalVenture");
        List<String> data = AdventReadInput.readData(is);

        //todo

        System.out.printf("At how many points do at least two lines overlap: %s", 0);
    }


    public static void main(String[] args) {
        new Day5HydrothermalVenture();
    }
}