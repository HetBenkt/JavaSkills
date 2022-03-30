package nl.bos.projecteuler;

import java.text.MessageFormat;

public class SmallestMultiple {
    private static final int MAX_VALUE = 20;

    public static void main(String[] args) {
        int index = 1;
        while (!canBeDividedByAll(index)) {
            index++;
        }
        System.out.println(MessageFormat.format("Index {0}", index));
    }

    private static boolean canBeDividedByAll(int index) {
        for (int i = 1; i <= MAX_VALUE; i++) {
            if ((index % i != 0)) {
                return false;
            }
        }
        return true;
    }
}
