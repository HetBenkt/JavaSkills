package nl.bos.kyu7;

import java.util.Arrays;

class RowSumOddNumbers {

    static int rowSumOddNumbers(int n) {
        if (n < 1)
            return -1;

        int startOddValue = 1;
        int[] row = new int[0];

        for (int i = 1; i <= n; i++) {
            row = new int[i];
            for (int j = 0; j < i; j++) {
                row[j] = startOddValue;
                startOddValue += 2;
            }
        }
        return Arrays.stream(row).sum();
    }
}
