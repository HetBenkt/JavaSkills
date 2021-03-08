package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11SeatingSystem {
    private static final boolean DEBUG = true;

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
                if (DEBUG) {
                    System.out.printf("%s", grid[i][j]);
                }
            }
            if (DEBUG) {
                System.out.println();
            }
        }
        if (DEBUG) {
            System.out.println();
        }


        int rounds = 0;
        char[][] result;
        boolean repeatFound = false;
        while (!repeatFound) {
            result = grid;
            grid = round(cols, rows, grid);
            if (DEBUG) {
                System.out.println(Arrays.deepToString(grid));
                System.out.println(Arrays.deepToString(result));
            }
            if (isEqualArray(grid, result)) {
                repeatFound = true;
            }
            rounds++;
        }

        long occupiedSeats = Arrays.deepToString(grid).chars().filter(ch -> ch == '#').count();
        System.out.println(String.format("Rounds = %d and seats = %d", rounds, occupiedSeats));
    }

    private boolean isEqualArray(char[][] grid, char[][] result) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != result[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private char[][] round(int cols, int rows, char[][] grid) {
        char[][] result = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1) {
                    result[i][j] = '.';
                } else if (j == 0 || j == cols - 1) {
                    result[i][j] = '.';
                } else {
                    char seat = grid[i][j];
                    AdjacentSeats[] adjacentSeats = getAdjacentSeats(grid, i, j);
                    if (seat == 'L' && occupiedSeatsAdjacent(adjacentSeats) == 0) {
                        result[i][j] = '#';
                    } else if (seat == '#' && occupiedSeatsAdjacent(adjacentSeats) >= 5) {
                        result[i][j] = 'L';
                    } else if (seat == '.') {
                        result[i][j] = '.';
                    } else {
                        result[i][j] = grid[i][j];
                    }
                }
                if (DEBUG) {
                    System.out.printf("%s", result[i][j]);
                }
            }
            if (DEBUG) {
                System.out.println();
            }
        }
        if (DEBUG) {
            System.out.println();
        }
        return result;
    }

    private int occupiedSeatsAdjacent(AdjacentSeats[] adjacentSeats) {
        int result = 0;
        for (AdjacentSeats adjacentSeat : adjacentSeats) {
            for (Character seat : adjacentSeat.getSeats()) {
                if (seat == '#') {
                    result++;
                }
            }
        }
        return result;
    }

    private AdjacentSeats[] getAdjacentSeats(char[][] grid, int row, int column) {
        AdjacentSeats[] result = new AdjacentSeats[8];
        result[0] = new AdjacentSeats(grid, row, column, -1, -1);//grid[row - 1][column - 1];
        result[1] = new AdjacentSeats(grid, row, column, -1, 0);//grid[row - 1][column];
        result[2] = new AdjacentSeats(grid, row, column, -1, 1);//grid[row - 1][column + 1];
        result[3] = new AdjacentSeats(grid, row, column, 0, -1);//grid[row][column - 1];
        result[4] = new AdjacentSeats(grid, row, column, 0, 1);//grid[row][column + 1];
        result[5] = new AdjacentSeats(grid, row, column, 1, -1);//grid[row + 1][column - 1];
        result[6] = new AdjacentSeats(grid, row, column, 1, 0);//grid[row + 1][column];
        result[7] = new AdjacentSeats(grid, row, column, 1, 1);//grid[row + 1][column + 1];

        return result;
    }

    public static void main(String[] args) {
        new Day11SeatingSystem();
    }

    private class AdjacentSeats {
        private final List<Character> seats = new ArrayList();

        public AdjacentSeats(char[][] grid, int row, int column, int directionRow, int directionColumn) {
            int directionRowFixed = directionRow;
            int directionColumnFixed = directionColumn;
            boolean error = false;
            while (!error) {
                try {
                    seats.add(grid[row + directionRow][column + directionColumn]);
                    directionRow += directionRowFixed;
                    directionColumn += directionColumnFixed;
                } catch (ArrayIndexOutOfBoundsException e) {
                    error = true;
                }
            }
        }

        public List<Character> getSeats() {
            return seats;
        }
    }
}
