package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day9SmokeBasin {

    public Day9SmokeBasin() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day9SmokeBasin");
        List<String> data = AdventReadInput.readData(is);

        //Make an empty grid
        int width = data.get(0).length() + 2;
        int height = data.size() + 2;
        int[][] grid = new int[height][width];
        Arrays.stream(grid).forEach(a -> Arrays.fill(a, -1));

        //Fill grid with data
        for (int row = 1; row < grid.length - 1; row++) {
            String[] split = data.get(row - 1).split("");
            for (int col = 1; col < grid[row].length - 1; col++) {
                grid[row][col] = Integer.parseInt(split[col - 1]);
            }
        }

        long result = 0L;

        for (int row = 1; row < grid.length - 1; row++) {
            for (int col = 1; col < grid[row].length - 1; col++) {
                List<Integer> adjacentValues = List.of(
                        grid[row + 1][col],
                        grid[row - 1][col],
                        grid[row][col + 1],
                        grid[row][col - 1])
                        .stream()
                        .filter(i -> i != -1)
                        .collect(Collectors.toList());

                int finalRow = row;
                int finalCol = col;
                long count = adjacentValues.stream().filter(integer -> grid[finalRow][finalCol] >= integer).count();
                if (count == 0L) {
                    result += grid[row][col] + 1;
                }
            }
        }

        System.out.printf("The sum of the risk levels of all low points on the heightmap: %s", result);
    }

    public static void main(String[] args) {
        new Day9SmokeBasin();
    }
}