package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;

public class Day3TobogganTrajectory {
    private final static int ROW_WIDTH = 31;

    public static void main(String[] args) {
        new Day3TobogganTrajectory();
    }

    public Day3TobogganTrajectory() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day3TobogganTrajectory");
        ArrayList<String> data = AdventReadInput.readData(is);

        ArrayList<Long> encounteredTrees = new ArrayList<>();
        encounteredTrees.add(getEncounteredTrees(data, 1, 1));
        encounteredTrees.add(getEncounteredTrees(data, 3, 1));
        encounteredTrees.add(getEncounteredTrees(data, 5, 1));
        encounteredTrees.add(getEncounteredTrees(data, 7, 1));
        encounteredTrees.add(getEncounteredTrees(data, 1, 2));

        System.out.println(String.format("Encountered trees = %d", encounteredTrees.stream().reduce(1L, (a, b) -> a * b)));
    }

    private long getEncounteredTrees(ArrayList<String> data, int columnJump, int rowJump) {
        int column = 0;
        int trees = 0;
        for (int row = 0; row < data.size(); row += rowJump) {
            char point = data.get(row).charAt(column);
            if (point == '#') {
                trees++;
            }
            column += columnJump;
            if (column >= ROW_WIDTH) {
                column = column - ROW_WIDTH;
            }
        }
        return trees;
    }
}
