package nl.bos.misc;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of rows for pascal triangle:");
        int input = scan.nextInt();
        System.out.printf("Pascal Triangle of %s is:", input);
        System.out.println();

        int width = input * 2;
        int height = input;
        String[][] result = buildTriangle(width, height);
        print(result);
    }

    private static void print(String[][] result) {
        for (String[] row : result) {
            for (String rowCell : row) {
                System.out.print(rowCell);
            }
            System.out.println();
        }
    }

    public static String[][] buildTriangle(int width, int height) {
        String[][] result = new String[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((height + i) < j) {
                    result[i][j] = "";
                } else {
                    result[i][j] = "_";
                    if (i == 0 && (j == height - 1)) {
                        result[i][j] = "1";
                    } else if (i == 1 && (j == height - 2 || j == height)) {
                        result[i][j] = "1";
                    } else if (i == 2 && (j == height - 1)) {
                        result[i][j] = "2";
                    } else if (i == 2 && (j == height - 3 || j == height + 1)) {
                        result[i][j] = "1";
                    } else if (i == 3 && (j == height - 2 || j == height)) {
                        result[i][j] = "3";
                    } else if (i == 3 && (j == height - 4 || j == height + 2)) {
                        result[i][j] = "1";
                    } else if (i == 4 && (j == height - 1)) {
                        result[i][j] = "6";
                    } else if (i == 4 && (j == height - 3 || j == height + 1)) {
                        result[i][j] = "4";
                    } else if (i == 4 && (j == height - 5 || j == height + 3)) {
                        result[i][j] = "1";
                    }
                }
            }
        }

        return result;
    }
}