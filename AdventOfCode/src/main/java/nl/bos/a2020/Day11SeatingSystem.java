package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day11SeatingSystem {

    public Day11SeatingSystem() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day11SeatingSystem");
        List<String> data = AdventReadInput.readData(is);

        int cols = data.get(0).length() + 2;
        int rows = data.size() + 2;
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1) {
                    grid[i][j] = '.';
                } else if (j == 0 || j == cols - 1) {
                    grid[i][j] = '.';
                } else {
                    grid[i][j] = data.get(i - 1).toCharArray()[j - 1];
                }
            }
        }

        System.out.print(String.format("Result = %d", 0));
    }

    public static void main(String[] args) {
        new Day11SeatingSystem();
    }
}
