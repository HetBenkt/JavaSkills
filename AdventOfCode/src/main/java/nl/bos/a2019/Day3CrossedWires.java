package nl.bos.a2019;

import nl.bos.general.AdventReadInput;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3CrossedWires {

    private static final int GRID_SIZE = 20_000;
    private final char[][] grid = new char[GRID_SIZE][GRID_SIZE];

    private static final int X1 = GRID_SIZE / 2;
    private static final int Y1 = GRID_SIZE / 2;
    private final List<Point> crossSections = new ArrayList<>();
    private int x2 = X1;
    private int y2 = Y1;

    public Day3CrossedWires() {
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }
        grid[X1][Y1] = 'o';

        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2019/Day3CrossedWires");
        ArrayList<String> wires = AdventReadInput.readData(is);

        String[] wireOne = wires.get(0).split(",");
        String[] wireTwo = wires.get(1).split(",");

        drawOnGrid(wireOne, true);
        x2 = GRID_SIZE / 2;
        y2 = GRID_SIZE / 2;
        drawOnGrid(wireTwo, false);

        int xf2;
        int yf2;
        int result = GRID_SIZE;

        for (Point crossSection : crossSections) {
            xf2 = (int) crossSection.getX();
            yf2 = (int) crossSection.getY();
            int manhattanDistance = Math.abs(X1 - xf2) + Math.abs(Y1 - yf2);
            if (result > manhattanDistance) {
                result = manhattanDistance;
            }
        }

        System.out.println("Manhattan distance: " + result);
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
                        updateGrid(isFirst, '|');
                    }
                    grid[x2][y2] = '+';
                }
                case 'D' -> {
                    for (int i = 0; i < length; i++) {
                        ++x2;
                        updateGrid(isFirst, '|');
                    }
                    grid[x2][y2] = '+';
                }
                case 'L' -> {
                    for (int i = 0; i < length; i++) {
                        --y2;
                        updateGrid(isFirst, '-');
                    }
                    grid[x2][y2] = '+';
                }
                case 'R' -> {
                    for (int i = 0; i < length; i++) {
                        ++y2;
                        updateGrid(isFirst, '-');
                    }
                    grid[x2][y2] = '+';
                }
                default -> throw new IllegalStateException("Unexpected value: " + instruction.charAt(0));
            }
        }
        //drawGrid();
    }

    private void updateGrid(boolean isFirst, char track) {
        if (!isFirst && (grid[x2][y2] == '-' || grid[x2][y2] == '|' || grid[x2][y2] == '+')) {
            grid[x2][y2] = 'X';
            crossSections.add(new Point(x2, y2));
        } else {
            grid[x2][y2] = track;
        }
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
