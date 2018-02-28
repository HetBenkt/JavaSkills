package nl.bos.projecteuler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.stream.Stream;

@Log
public class MaximumPathSumI {
    private static final int SIZE = 15;
    private static Item[][] tree = new Item[SIZE][SIZE];

    public static void main(String[] args) {
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
    }

    private static void addLineToTreeArray(String line, int lineNr) {
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        int tokenIndex = 0;
        while (tokenizer.hasMoreTokens()) {
            String value = tokenizer.nextToken();
            tree[lineNr][tokenIndex] = new Item(Integer.parseInt(value), false);
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
