package nl.bos.kyu5;

public class NumberOfTrailingZerosOfFactorioN {

    public static int zeros(int n) {
        int fiver = 5;
        int result = 0;

        int temp;
        do {
            temp = n / fiver;
            fiver *= 5;
            result += temp;
        } while (temp > 0);

        return result;
    }
}
