package nl.bos.projecteuler;

import lombok.extern.java.Log;

import java.text.MessageFormat;

@Log
public class LatticePaths {
    private static final int GRID_SIZE = 20;
    private static final int SIZE = GRID_SIZE + 1;

    public static void main(String[] args) {
        //int values are too short as we get a wrong answer: 407575348
        long[][] grid = new long[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                grid[row][column] = 1;
                if (row > 0 && column > 0) {
                    grid[row][column] = grid[row - 1][column] + grid[row][column - 1];
                }
            }
        }
        log.info(MessageFormat.format("Total routes for grid size {0} is: {1}", GRID_SIZE, grid[GRID_SIZE][GRID_SIZE]));
    }
}
