package nl.bos.kyu6;

import java.util.Arrays;

public class CoinFree {
    public static int solve(int amount, int[] coinAmounts) {
        Arrays.sort(coinAmounts);
        int result = 0;
        for (int i = coinAmounts.length - 1; i >= 0; i--) {
            int devider = amount / coinAmounts[i];
            result += devider;
            amount -= coinAmounts[i] * devider;
            if (amount == 0) {
                break;
            }
        }
        return result;
    }
}
