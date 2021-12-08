package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day5HydrothermalVenture {

    public Day5HydrothermalVenture() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day5HydrothermalVenture");
        List<String> data = AdventReadInput.readData(is);
        List<Line> lines = prepareDate(data);

        int maxX = Collections.max(getIntegers(lines.stream().map(Line::x1), lines.stream().map(Line::x2), lines));
        int maxY = Collections.max(getIntegers(lines.stream().map(Line::y1), lines.stream().map(Line::y2), lines));

        int[][] grid = new int[maxX + 1][maxY + 1];

        List<Line> horizontalLines = lines.stream()
                .filter(line -> line.direction == EDirection.HORIZONTAL)
                .collect(Collectors.toList());
        List<Line> verticalLines = lines.stream()
                .filter(line -> line.direction == EDirection.VERTICAL)
                .collect(Collectors.toList());
        List<Line> otherLines = lines.stream()
                .filter(line -> line.direction == EDirection.OTHER)
                .collect(Collectors.toList());

        for (Line line : horizontalLines) {
            int[] indexes = IntStream.rangeClosed(
                    line.x1 < line.x2 ? line.x1 : line.x2,
                    line.x1 < line.x2 ? line.x2 : line.x1)
                    .toArray();
            for (int index : indexes) {
                grid[index][line.y1]++;
            }
        }

        for (Line line : verticalLines) {
            int[] indexes = IntStream.rangeClosed(
                    line.y1 < line.y2 ? line.y1 : line.y2,
                    line.y1 < line.y2 ? line.y2 : line.y1)
                    .toArray();
            for (int index : indexes) {
                grid[line.x1][index]++;
            }
        }

        for (Line line : otherLines) {
            //todo; these diagonal lines can have 4 different direction!!??
        }

        System.out.printf(
                "At how many points do at least two lines overlap: %s",
                Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(integer -> integer >= 2).count()
        );
    }

    private List<Line> prepareDate(List<String> data) {
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

        return lines;
    }

    private List<Integer> getIntegers(Stream<Integer> integerStream, Stream<Integer> integerStream2, List<Line> lines) {
        List<Integer> listX1 = integerStream.collect(Collectors.toList());
        List<Integer> listX2 = integerStream2.collect(Collectors.toList());
        List<Integer> x1X2 = new ArrayList<>();
        x1X2.addAll(listX1);
        x1X2.addAll(listX2);
        return x1X2;
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