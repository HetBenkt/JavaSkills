package nl.bos.arrays;

public class PerfectSquarePatch {
    public static int[][] squarePatch(int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = n;
            }
        }

        return result;
    }
}
