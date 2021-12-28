package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11DumboOctopus {

    public Day11DumboOctopus() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day11DumboOctopus");
        List<String> dumboOctopuses = AdventReadInput.readData(is);

        //Make an empty grid
        int width = dumboOctopuses.get(0).length() + 2;
        int height = dumboOctopuses.size() + 2;
        int[][] grid = new int[height][width];
        Arrays.stream(grid).forEach(a -> Arrays.fill(a, -1));

        //Fill grid with data
        for (int row = 1; row < grid.length - 1; row++) {
            String[] split = dumboOctopuses.get(row - 1).split("");
            for (int col = 1; col < grid[row].length - 1; col++) {
                grid[row][col] = Integer.parseInt(split[col - 1]);
            }
        }

        long result = 0L;

        for (int i = 0; i < 100; i++) {

            List<Point> flashCoordinates = new ArrayList<>();
            //the energy level of each octopus increases by 1
            for (int row = 1; row < grid.length - 1; row++) {
                for (int col = 1; col < grid[row].length - 1; col++) {
                    grid[row][col] += 1;
                    if (grid[row][col] == 10) {
                        flashCoordinates.add(new Point(row, col));
                    }
                }
            }

            while (flashCoordinates.size() > 1) {
                flashCoordinates = doTheFlash(grid, flashCoordinates);
            }
        }

        System.out.printf("Total flashes after 100 steps: %s", result);
    }

    private List<Point> doTheFlash(int[][] grid, List<Point> flashCoordinates) {
        List<Point> result = new ArrayList<>();

        //any octopus with an energy level greater than 9 flashes
        for (Point flashCoordinate : flashCoordinates) {
            //top row
            if (grid[(int) flashCoordinate.getX() - 1][(int) flashCoordinate.getY() - 1] != -1) {
                grid[(int) flashCoordinate.getX() - 1][(int) flashCoordinate.getY() - 1] += 1;
                if (grid[(int) flashCoordinate.getX() - 1][(int) flashCoordinate.getY() - 1] == 10) {
                    result.add(new Point((int) flashCoordinate.getX() - 1, (int) flashCoordinate.getY() - 1));
                }
            }
            if (grid[(int) flashCoordinate.getX()][(int) flashCoordinate.getY() - 1] != -1) {
                grid[(int) flashCoordinate.getX()][(int) flashCoordinate.getY() - 1] += 1;
                if (grid[(int) flashCoordinate.getX()][(int) flashCoordinate.getY() - 1] == 10) {
                    result.add(new Point((int) flashCoordinate.getX(), (int) flashCoordinate.getY() - 1));
                }
            }
            if (grid[(int) flashCoordinate.getX() + 1][(int) flashCoordinate.getY() - 1] != -1) {
                grid[(int) flashCoordinate.getX() + 1][(int) flashCoordinate.getY() - 1] += 1;
                if (grid[(int) flashCoordinate.getX() + 1][(int) flashCoordinate.getY() - 1] == 10) {
                    result.add(new Point((int) flashCoordinate.getX() + 1, (int) flashCoordinate.getY() - 1));
                }
            }

            //middle row
            if (grid[(int) flashCoordinate.getX() - 1][(int) flashCoordinate.getY()] != -1) {
                grid[(int) flashCoordinate.getX() - 1][(int) flashCoordinate.getY()] += 1;
                if (grid[(int) flashCoordinate.getX() - 1][(int) flashCoordinate.getY()] == 10) {
                    result.add(new Point((int) flashCoordinate.getX() - 1, (int) flashCoordinate.getY()));
                }
            }
            if (grid[(int) flashCoordinate.getX() + 1][(int) flashCoordinate.getY()] != -1) {
                grid[(int) flashCoordinate.getX() + 1][(int) flashCoordinate.getY()] += 1;
                if (grid[(int) flashCoordinate.getX() + 1][(int) flashCoordinate.getY()] == 10) {
                    result.add(new Point((int) flashCoordinate.getX() + 1, (int) flashCoordinate.getY()));
                }
            }

            //bottom row
            if (grid[(int) flashCoordinate.getX() - 1][(int) flashCoordinate.getY() + 1] != -1) {
                grid[(int) flashCoordinate.getX() - 1][(int) flashCoordinate.getY() + 1] += 1;
                if (grid[(int) flashCoordinate.getX() - 1][(int) flashCoordinate.getY() + 1] == 10) {
                    result.add(new Point((int) flashCoordinate.getX() - 1, (int) flashCoordinate.getY() + 1));
                }
            }
            if (grid[(int) flashCoordinate.getX()][(int) flashCoordinate.getY() + 1] != -1) {
                grid[(int) flashCoordinate.getX()][(int) flashCoordinate.getY() + 1] += 1;
                if (grid[(int) flashCoordinate.getX()][(int) flashCoordinate.getY() + 1] == 10) {
                    result.add(new Point((int) flashCoordinate.getX(), (int) flashCoordinate.getY() + 1));
                }
            }
            if (grid[(int) flashCoordinate.getX() + 1][(int) flashCoordinate.getY() + 1] != -1) {
                grid[(int) flashCoordinate.getX() + 1][(int) flashCoordinate.getY() + 1] += 1;
                if (grid[(int) flashCoordinate.getX() + 1][(int) flashCoordinate.getY() + 1] == 10) {
                    result.add(new Point((int) flashCoordinate.getX() + 1, (int) flashCoordinate.getY() + 1));
                }
            }

            grid[(int) flashCoordinate.getX()][(int) flashCoordinate.getY()] = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        new Day11DumboOctopus();
    }
}