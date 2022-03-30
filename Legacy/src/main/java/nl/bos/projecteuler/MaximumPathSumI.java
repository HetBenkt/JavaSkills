package nl.bos.projecteuler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class MaximumPathSumI {
    private static int size;
    private static int[][] tree;

    public static void main(String[] args) {
        initTreeArray();
        for (int i = size-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int child1 = tree[i][j];
                int child2 = tree[i][j + 1];

                if (child1 > child2) {
                    tree[i - 1][j] += child1;
                } else {
                    tree[i - 1][j] += child2;
                }
            }
        }
        System.out.println(MessageFormat.format("Result: {0}", tree[0][0]));
    }

    private static void initTreeArray() {
        //read input file and fill the array
        Class maximumPathSumIClass = MaximumPathSumI.class;
        Path path = Paths.get("src//nl//bos//projecteuler//" + maximumPathSumIClass.getSimpleName() + ".in").toAbsolutePath();
        try (Stream<String> stream = Files.lines(path)) {
            String[] lines = stream.toArray(String[]::new);

            String lastLine = lines[lines.length-1];
            StringTokenizer tokenizer = new StringTokenizer(lastLine, " ");
            size = tokenizer.countTokens();
            tree = new int[size][size];

            int lineNr = 0;
            for (String line : lines) {
                System.out.println(line);
                addLineToTreeArray(line, lineNr);
                lineNr++;
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void addLineToTreeArray(String line, int lineNr) {
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        int tokenIndex = 0;
        while (tokenizer.hasMoreTokens()) {
            int value = Integer.parseInt(tokenizer.nextToken());
            tree[lineNr][tokenIndex] = value;
            tokenIndex++;
        }
    }
}
