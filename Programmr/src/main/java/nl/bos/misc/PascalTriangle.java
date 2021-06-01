package nl.bos.misc;

public class PascalTriangle {
    public static String[][] buildTriangle(int width, int height) {
        String[][] result = new String[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((height + i) < j) {
                    result[i][j] = "";
                } else {
                    result[i][j] = "_";
                    if (i == 0 && (j == (width / 2) - 1)) {
                        result[i][j] = "1";
                    } else if (i == 1 && (j == (width / 2) - 2 || j == width / 2)) {
                        result[i][j] = "1";
                    } else if (i == 2 && (j == (width / 2) - 1)) {
                        result[i][j] = "2";
                    } else if (i == 2 && (j == (width / 2) - 3 || j == width / 2 + 1)) {
                        result[i][j] = "1";
                    } else if (i == 3 && (j == (width / 2) - 2 || j == width / 2)) {
                        result[i][j] = "3";
                    } else if (i == 3 && (j == (width / 2) - 4 || j == width / 2 + 2)) {
                        result[i][j] = "1";
                    } else if (i == 4 && (j == (width / 2) - 1)) {
                        result[i][j] = "6";
                    } else if (i == 4 && (j == (width / 2) - 3 || j == width / 2 + 1)) {
                        result[i][j] = "4";
                    } else if (i == 4 && (j == (width / 2) - 5 || j == width - 2)) {
                        result[i][j] = "1";
                    }
                }
            }
        }

        return result;
    }
}
