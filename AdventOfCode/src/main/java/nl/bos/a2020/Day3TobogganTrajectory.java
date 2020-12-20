package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;

public class Day3TobogganTrajectory {
    private final static int ROW_WIDTH = 31;

    public Day3TobogganTrajectory() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day3TobogganTrajectory");
        ArrayList<String> data = AdventReadInput.readData(is);

        int column = 0;
        int trees = 0;
        for (int row = 0; row < data.size(); row++) {
            char point = data.get(row).charAt(column);
            if (point == '#') {
                trees++;
            }
            column += 3;
            if (column >= ROW_WIDTH) {
                column = column - ROW_WIDTH;
            }
        }

        System.out.println(String.format("Encountered trees = %d", trees));
    }

    public static void main(String[] args) {
        new Day3TobogganTrajectory();
    }
}
