package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day15RambunctiousRecitation {

    public Day15RambunctiousRecitation() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day15RambunctiousRecitation");
        List<String> data = AdventReadInput.readData(is);

        //TODO

        System.out.println(String.format("The 2020th number spoken = %d", 0));
    }

    public static void main(String[] args) {
        new Day15RambunctiousRecitation();
    }
}