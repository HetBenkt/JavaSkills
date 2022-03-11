package nl.bos.a2019;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

//13647 is too high!
public class Day3CrossedWires {

    private static final int GRID_SIZE = 500;
    private final char[][] grid = new char[GRID_SIZE][GRID_SIZE];

    private final int x1 = GRID_SIZE / 2;
    private final int y1 = GRID_SIZE / 2;
    private int x2 = GRID_SIZE / 2;
    private int y2 = GRID_SIZE / 2;
    private int xf2;
    private int yf2;


    public Day3CrossedWires() {
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }
        grid[x1][y1] = 'o';

        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2019/Day3CrossedWires");
        ArrayList<String> wires = AdventReadInput.readData(is);

        String[] wireOne = wires.get(0).split(",");
        String[] wireTwo = wires.get(1).split(",");

        drawOnGrid(wireOne, true);
        x2 = GRID_SIZE / 2;
        y2 = GRID_SIZE / 2;
        drawOnGrid(wireTwo, false);

        int manhattanDistance = Math.abs(x1 - xf2) + Math.abs(y1 - yf2);
        System.out.println("Manhattan distance: " + manhattanDistance);
    }

    public static void main(String[] args) {
        new Day3CrossedWires();
    }

    private void drawOnGrid(String[] wireOne, boolean isFirst) {
        for (String instruction : wireOne) {
            int length = Integer.parseInt(instruction.substring(1));
            switch (instruction.charAt(0)) {
                case 'U' -> {
                    for (int i = 0; i < length; i++) {
                        --x2;
                        if (!isFirst && (grid[x2][y2] == '-' || grid[x2][y2] == '|' || grid[x2][y2] == '+')) {
                            grid[x2][y2] = 'X';
                            xf2 = x2;
                            yf2 = y2;
                        } else {
                            grid[x2][y2] = '|';
                        }
                    }
                    grid[x2][y2] = '+';
                }
                case 'D' -> {
                    for (int i = 0; i < length; i++) {
                        ++x2;
                        if (!isFirst && (grid[x2][y2] == '-' || grid[x2][y2] == '|' || grid[x2][y2] == '+')) {
                            grid[x2][y2] = 'X';
                            xf2 = x2;
                            yf2 = y2;
                        } else {
                            grid[x2][y2] = '|';
                        }
                    }
                    grid[x2][y2] = '+';
                }
                case 'L' -> {
                    for (int i = 0; i < length; i++) {
                        --y2;
                        if (!isFirst && (grid[x2][y2] == '-' || grid[x2][y2] == '|' || grid[x2][y2] == '+')) {
                            grid[x2][y2] = 'X';
                            xf2 = x2;
                            yf2 = y2;
                        } else {
                            grid[x2][y2] = '-';
                        }
                    }
                    grid[x2][y2] = '+';
                }
                case 'R' -> {
                    for (int i = 0; i < length; i++) {
                        ++y2;
                        if (!isFirst && (grid[x2][y2] == '-' || grid[x2][y2] == '|' || grid[x2][y2] == '+')) {
                            grid[x2][y2] = 'X';
                            xf2 = x2;
                            yf2 = y2;
                        } else {
                            grid[x2][y2] = '-';
                        }
                    }
                    grid[x2][y2] = '+';
                }
                default -> throw new IllegalStateException("Unexpected value: " + instruction.charAt(0));
            }
        }
        drawGrid();
    }

    private void drawGrid() {
        for (char[] row : grid) {
            for (char point : row) {
                System.out.print(point);
            }
            System.out.println();
        }
    }

}
