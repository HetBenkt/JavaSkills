package nl.bos.projecteuler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.StringTokenizer;
import java.util.stream.Stream;

@Log
public class MaximumPathSumI {
    private static final int SIZE = 15;
    private static Item[][] tree = new Item[SIZE][SIZE];
    private static int totalSum = 0;
    private static int totalValues = 0;
    private static int average;

    public static void main(String[] args) {
        //read input file and fill the array
        Class maximumPathSumIClass = MaximumPathSumI.class;
        Path path = Paths.get("src//nl//bos//projecteuler//" + maximumPathSumIClass.getSimpleName() + ".in").toAbsolutePath();
        try (Stream<String> stream = Files.lines(path)) {
            String[] lines = stream.toArray(String[]::new);
            int lineNr = 0;
            for (String line : lines) {
                log.info(line);
                addLineToTreeArray(line, lineNr);
                lineNr++;
            }
        } catch (Exception e) {
            log.finest(e.getLocalizedMessage());
        }

        //get the average
        average = totalSum / totalValues;
        log.info(MessageFormat.format("The average value is {0}", average));

        //make all values in array usable that are > the average and next line values are > average
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (tree[i][j] != null) {
                    Item item = tree[i][j];
                    if ((item.getValue() > average) && nextLineValuesAreAboveAverage(i, j)) {
                        item.setUseable(true);
                    }
                } else {
                    j = SIZE;
                }
            }
        }
    }

    private static boolean nextLineValuesAreAboveAverage(int i, int j) {
        //Check last line; for arrayOutOfBounce!
        if (i + 1 != SIZE) {
            if (tree[i + 1][j].getValue() > average || tree[i + 1][j + 1].getValue() > average)
                return true;
            else
                return false;
        } else {
            return true;
        }
    }

    private static void addLineToTreeArray(String line, int lineNr) {
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        int tokenIndex = 0;
        while (tokenizer.hasMoreTokens()) {
            int value = Integer.parseInt(tokenizer.nextToken());
            totalSum += value;
            totalValues++;
            tree[lineNr][tokenIndex] = new Item(value, false);
            tokenIndex++;
        }
    }

    @AllArgsConstructor
    @Data
    private static class Item {
        private int value;
        private boolean isUseable;
    }
}
