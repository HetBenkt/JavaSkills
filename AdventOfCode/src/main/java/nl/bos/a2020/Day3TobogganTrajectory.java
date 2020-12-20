package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;

public class Day3TobogganTrajectory {

    public Day3TobogganTrajectory() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day3TobogganTrajectory");
        ArrayList<String> data = AdventReadInput.readData(is);


    }

    public static void main(String[] args) {
        new Day3TobogganTrajectory();
    }
}
