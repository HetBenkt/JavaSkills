package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day8SevenSegmentSearch {

    public Day8SevenSegmentSearch() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day8SevenSegmentSearch");
        List<String> data = AdventReadInput.readData(is);

        //todo

        System.out.printf("# of times digits 1, 4, 7, or 8 appear: %s", 0);
    }

    public static void main(String[] args) {
        new Day8SevenSegmentSearch();
    }
}