package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day13ShuttleSearch {

    public Day13ShuttleSearch() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day13ShuttleSearch");
        List<String> data = AdventReadInput.readData(is);

        //TODO

        System.out.println(String.format("ID of the earliest bus = %d", 0));
    }

    public static void main(String[] args) {
        new Day13ShuttleSearch();
    }
}