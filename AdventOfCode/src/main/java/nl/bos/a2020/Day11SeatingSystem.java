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
                System.out.printf("%s", grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();


        char[][] grid2 = round(cols, rows, grid);
        char[][] grid3 = round(cols, rows, grid2);


        System.out.println(String.format("Result = %d", 0));
    }

    private char[][] round(int cols, int rows, char[][] grid) {
        char[][] grid2 = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1) {
                    grid2[i][j] = '.';
                } else if (j == 0 || j == cols - 1) {
                    grid2[i][j] = '.';
                } else {
                    char seat = grid[i][j];
                    char[] adjacentSeats = getAdjacentSeats(grid, i, j);
                    if (seat == 'L' && occupiedSeatsAdjacent(adjacentSeats) == 0) {
                        grid2[i][j] = '#';
                    } else if (seat == '#' && occupiedSeatsAdjacent(adjacentSeats) >= 4) {
                        grid2[i][j] = 'L';
                    } else if (seat == '.') {
                        grid2[i][j] = '.';
                    } else {
                        grid2[i][j] = grid[i][j];
                    }
                }
                System.out.printf("%s", grid2[i][j]);
            }
            System.out.println();
        }
        return grid2;
    }

    private int occupiedSeatsAdjacent(char[] adjacentSeats) {
        int result = 0;
        for (char adjacentSeat : adjacentSeats) {
            if (adjacentSeat == '#') {
                result++;
            }
        }
        return result;
    }

    private char[] getAdjacentSeats(char[][] grid, int i, int j) {
        char[] result = new char[8];
        result[0] = grid[i - 1][j - 1];
        result[1] = grid[i - 1][j];
        result[2] = grid[i - 1][j + 1];
        result[3] = grid[i][j - 1];
        result[4] = grid[i][j + 1];
        result[5] = grid[i + 1][j - 1];
        result[6] = grid[i + 1][j];
        result[7] = grid[i + 1][j + 1];

        return result;
    }

    public static void main(String[] args) {
        new Day11SeatingSystem();
    }
}
