package nl.bos.projecteuler;

public class Prime10001 {
    private static int input_value = 10001;
    private static int value = 2;

    public static void main(String[] args) {
        int primeValue = 0;
        for (int i = 0; i < input_value; i++) {
            primeValue = getNextPrimeNumber();
            value++;
        }
        System.out.println(primeValue);
    }

    private static int getNextPrimeNumber() {
        while (!isPrimeNumber()) {
            value++;
        }
        return value;
    }

    private static boolean isPrimeNumber() {
        for (int i = 2; i < value; i++) {
            if (value % i == 0)
                return false;
        }
        return true;
    }
}
