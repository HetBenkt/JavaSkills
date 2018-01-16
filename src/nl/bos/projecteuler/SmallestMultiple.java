package nl.bos.projecteuler;

public class SmallestMultiple {
    public static final int MAX_VALUE = 20;

    public static void main(String[] args) {
        int index = 1;
        while (!canBeDevidedByAll(index)) {
            index++;
        }
        System.out.println(index);
    }

    private static boolean canBeDevidedByAll(int index) {
        boolean result = true;
        for (int i = 1; i <= MAX_VALUE; i++) {
            if (!(index % i == 0)) {
                return false;
            }
        }
        return result;
    }
}
