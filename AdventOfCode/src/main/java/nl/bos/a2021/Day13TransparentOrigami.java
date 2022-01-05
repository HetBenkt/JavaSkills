package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.awt.*;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Day13TransparentOrigami {

    public Day13TransparentOrigami() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day13TransparentOrigami");
        List<String> data = AdventReadInput.readData(is);

        List<String> folds = data.stream().filter(s -> s.startsWith("fold")).map(s -> s.substring(11)).collect(Collectors.toList());
        List<Point> coordinates = data.stream().filter(s -> s.contains(",")).map(s -> {
            String[] split = s.split(",");
            return new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }).collect(Collectors.toList());

        Integer width = data.stream().filter(s -> s.contains(",")).mapToInt(s -> {
            String[] split = s.split(",");
            return Integer.parseInt(split[0]);
        }).max().orElseThrow(NoSuchElementException::new);
        Integer height = data.stream().filter(s -> s.contains(",")).mapToInt(s -> {
            String[] split = s.split(",");
            return Integer.parseInt(split[1]);
        }).max().orElseThrow(NoSuchElementException::new);

        char[][] grid = new char[height + 1][width + 1];
        Arrays.stream(grid).forEach(a -> Arrays.fill(a, '.'));

        for (Point coordinate : coordinates) {
            grid[(int) coordinate.getY()][(int) coordinate.getX()] = '#';
        }

        String firstFold = folds.get(0);

        //todo

        System.out.printf("Visible dots after completing just the first fold instruction on your transparent paper: %s", 0);
    }

    public static void main(String[] args) {
        new Day13TransparentOrigami();
    }
}