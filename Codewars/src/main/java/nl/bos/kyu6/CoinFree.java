package nl.bos.kyu6;

import java.util.Arrays;

public class CoinFree {
    public static int solve(int amount, int[] coinAmounts) {
        Arrays.sort(coinAmounts);
        int result = 0;
        for (int i = coinAmounts.length - 1; i >= 0; i--) {
            while (amount - coinAmounts[i] >= 0) {
                amount -= coinAmounts[i];
                result++;
            }
        }
        return result;
    }
}
