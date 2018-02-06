package nl.bos.projecteuler;

import lombok.extern.java.Log;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.StringTokenizer;
import java.util.stream.Stream;

@Log
public class LargestProductInAGrid {
    private static final int SIZE = 20;
    private static final long[][] grid = new long[SIZE][SIZE];
    private static long highestProduct = 0L;

    public static void main(String[] args) {
        initIntegerGrid();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i >= 3) {
                    calcUp(i, j);
                    if (j >= 3) {
                        calcDiagUpLeft(i, j);
                    }
                    if (j <= 16) {
                        calcDiagUpRight(i, j);
                    }
                }
                if (i <= 16) {
                    calcDown(i, j);
                    if (j >= 3) {
                        calcDiagDownLeft(i, j);
                    }
                    if (j <= 16) {
                        calcDiagDownRight(i, j);
                    }
                }
                if (j >= 3) {
                    calcLeft(i, j);
                }
                if (j <= 16) {
                    calcRight(i, j);
                }
            }
        }
        log.info(MessageFormat.format("Highest product {0}", highestProduct));
    }

    private static void calcDiagDownRight(int i, int j) {
        long product = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3];
        if (product > highestProduct) {
            highestProduct = product;
            log.info(MessageFormat.format("calcDiagDownRight::Higher product found: {0}, {1}, {2}, {3}", grid[i][j], grid[i + 1][j + 1], grid[i + 2][j + 2], grid[i + 3][j + 3]));
        }
    }

    private static void calcDiagDownLeft(int i, int j) {
        long product = grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2] * grid[i + 3][j - 3];
        if (product > highestProduct) {
            highestProduct = product;
            log.info(MessageFormat.format("calcDiagDownLeft::Higher product found: {0}, {1}, {2}, {3}", grid[i][j], grid[i + 1][j - 1], grid[i + 2][j - 2], grid[i + 3][j - 3]));
        }
    }

    private static void calcDiagUpRight(int i, int j) {
        long product = grid[i][j] * grid[i - 1][j + 1] * grid[i - 2][j + 2] * grid[i - 3][j + 3];
        if (product > highestProduct) {
            highestProduct = product;
            log.info(MessageFormat.format("calcDiagUpRight::Higher product found: {0}, {1}, {2}, {3}", grid[i][j], grid[i - 1][j + 1], grid[i - 2][j + 2], grid[i - 3][j + 3]));
        }
    }

    private static void calcDiagUpLeft(int i, int j) {
        long product = grid[i][j] * grid[i - 1][j - 1] * grid[i - 2][j - 2] * grid[i - 3][j - 3];
        if (product > highestProduct) {
            highestProduct = product;
            log.info(MessageFormat.format("calcDiagUpLeft::Higher product found: {0}, {1}, {2}, {3}", grid[i][j], grid[i - 1][j - 1], grid[i - 2][j - 2], grid[i - 3][j - 3]));
        }
    }

    private static void calcRight(int i, int j) {
        long product = grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3];
        if (product > highestProduct) {
            highestProduct = product;
            log.info(MessageFormat.format("calcRight::Higher product found: {0}, {1}, {2}, {3}", grid[i][j], grid[i][j + 1], grid[i][j + 2], grid[i][j + 3]));
        }
    }

    private static void calcLeft(int i, int j) {
        long product = grid[i][j] * grid[i][j - 1] * grid[i][j - 2] * grid[i][j - 3];
        if (product > highestProduct) {
            highestProduct = product;
            log.info(MessageFormat.format("calcLeft::Higher product found: {0}, {1}, {2}, {3}", grid[i][j], grid[i][j - 1], grid[i][j - 2], grid[i][j - 3]));
        }
    }

    private static void calcDown(int i, int j) {
        long product = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j];
        if (product > highestProduct) {
            highestProduct = product;
            log.info(MessageFormat.format("calcDown::Higher product found: {0}, {1}, {2}, {3}", grid[i][j], grid[i + 1][j], grid[i + 2][j], grid[i + 3][j]));
        }
    }

    private static void calcUp(int i, int j) {
        long product = grid[i][j] * grid[i - 1][j] * grid[i - 2][j] * grid[i - 3][j];
        if (product > highestProduct) {
            highestProduct = product;
            log.info(MessageFormat.format("calcUp::Higher product found: {0}, {1}, {2}, {3}", grid[i][j], grid[i - 1][j], grid[i - 2][j], grid[i - 3][j]));
        }
    }

    private static void initIntegerGrid() {
        Class largestProductInAGrid = LargestProductInAGrid.class;
        String fileName = largestProductInAGrid.getClass().getSimpleName();
        Path path = Paths.get("src//nl//bos//projecteuler//" + fileName + ".in").toAbsolutePath();
        try (Stream<String> stream = Files.lines(path)) {
            String[] lines = stream.toArray(String[]::new);
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                StringTokenizer tokens = new StringTokenizer(line, " ");
                int tokenIndex = 0;
                while (tokens.hasMoreTokens()) {
                    String value = tokens.nextToken();
                    grid[i][tokenIndex] = Integer.parseInt(value);
                    tokenIndex++;
                }
            }
        } catch (Exception e) {
            log.finest(e.getMessage());
        }
        log.info("Grid initialized!");
    }
}
