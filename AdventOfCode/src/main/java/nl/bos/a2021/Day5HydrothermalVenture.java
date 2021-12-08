package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5HydrothermalVenture {

    public Day5HydrothermalVenture() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day5HydrothermalVenture");
        List<String> data = AdventReadInput.readData(is);

        //Prepare data
        List<Line> lines = new ArrayList<>();
        for (String row : data) {
            String[] split = row.split(" -> ");
            String[] left = split[0].split(",");
            String[] right = split[1].split(",");

            int x1 = Integer.parseInt(left[0]);
            int y1 = Integer.parseInt(left[1]);
            int x2 = Integer.parseInt(right[0]);
            int y2 = Integer.parseInt(right[1]);

            EDirection direction;
            if (x1 == x2) {
                direction = EDirection.VERTICAL;
            } else if (y1 == y2) {
                direction = EDirection.HORIZONTAL;
            } else {
                direction = EDirection.OTHER;
            }

            Line line = new Line(x1, y1, x2, y2, direction);
            lines.add(line);
        }

        int maxX = Collections.max(listX(lines));
        int maxY = Collections.max(listY(lines));

        int[][] grid = new int[maxX + 1][maxY + 1];

        List<Line> horizontalLines = lines.stream().filter(line -> line.direction == EDirection.HORIZONTAL).collect(Collectors.toList());
        List<Line> verticalLines = lines.stream().filter(line -> line.direction == EDirection.VERTICAL).collect(Collectors.toList());

        for (Line horizontalLine : horizontalLines) {
            int[] intsX = IntStream.rangeClosed(horizontalLine.x1 < horizontalLine.x2 ? horizontalLine.x1 : horizontalLine.x2, horizontalLine.x1 < horizontalLine.x2 ? horizontalLine.x2 : horizontalLine.x1).toArray();
            for (int x : intsX) {
                grid[x][horizontalLine.y1]++;
            }
        }

        for (Line verticalLine : verticalLines) {
            int[] intsY = IntStream.rangeClosed(verticalLine.y1 < verticalLine.y2 ? verticalLine.y1 : verticalLine.y2, verticalLine.y1 < verticalLine.y2 ? verticalLine.y2 : verticalLine.y1).toArray();
            for (int y : intsY) {
                grid[verticalLine.x1][y]++;
            }
        }

        long count = Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(integer -> integer >= 2).count();

        System.out.printf("At how many points do at least two lines overlap: %s", count);
    }

    private List<Integer> listX(List<Line> lines) {
        List<Integer> listX1 = lines.stream().map(Line::x1).collect(Collectors.toList());
        List<Integer> listX2 = lines.stream().map(Line::x2).collect(Collectors.toList());
        List<Integer> x1X2 = new ArrayList<>();
        x1X2.addAll(listX1);
        x1X2.addAll(listX2);
        return x1X2;
    }

    private List<Integer> listY(List<Line> lines) {
        List<Integer> listY1 = lines.stream().map(Line::y1).collect(Collectors.toList());
        List<Integer> listY2 = lines.stream().map(Line::y2).collect(Collectors.toList());
        List<Integer> y1Y2 = new ArrayList<>();
        y1Y2.addAll(listY1);
        y1Y2.addAll(listY2);
        return y1Y2;
    }


    public static void main(String[] args) {
        new Day5HydrothermalVenture();
    }

    public enum EDirection {
        VERTICAL, HORIZONTAL, OTHER
    }

    public record Line(int x1, int y1, int x2, int y2, EDirection direction) {
    }
}