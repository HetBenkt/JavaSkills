package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;

public class Day1SonarSweep {

    public Day1SonarSweep() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day1SonarSweep");
        ArrayList<String> data = AdventReadInput.readData(is);

        //todo
    }

    public static void main(String[] args) {
        new Day1SonarSweep();
    }
}
