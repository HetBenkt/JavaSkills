package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day11SeatingSystem {

    public Day11SeatingSystem() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day11SeatingSystem");
        List<String> data = AdventReadInput.readData(is);

        int cols = data.get(0).length() + 1;
        int rows = data.size() + 1;
        char[][] grid = new char[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == 0 || i == cols - 1) {
                    grid[i][j] = '.';
                } else if (j == 0 || j == rows - 1) {
                    grid[i][j] = '.';
                } else {
                    grid[i][j] = '#';
                }
            }
        }

        System.out.print(String.format("Result = %d", 0));
    }

    public static void main(String[] args) {
        new Day11SeatingSystem();
    }
}
