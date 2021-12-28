package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day11DumboOctopus {

    public Day11DumboOctopus() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day11DumboOctopus");
        List<String> dumboOctopuses = AdventReadInput.readData(is);

        //todo

        System.out.printf("Total flashes after 100 steps: %s", 0);
    }

    public static void main(String[] args) {
        new Day11DumboOctopus();
    }
}