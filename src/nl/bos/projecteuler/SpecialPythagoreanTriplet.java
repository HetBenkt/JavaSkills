package nl.bos.projecteuler;

import java.text.MessageFormat;

public class SpecialPythagoreanTriplet {
    private static final int POW = 2;
    private static final int SPECIAL = 1000;
    private static double a = 0;
    private static double b = 1;
    private static double c = 0;

    public static void main(String[] args) {
        while (a + b + c != SPECIAL) {
            double a2 = Math.pow(a, POW);
            double b2 = Math.pow(b, POW);
            c = Math.sqrt(a2 + b2);
            if (c % 1 == 0) {
                if (a + b + c == SPECIAL) {
                    System.out.println(MessageFormat.format("PRODUCT: {0}", (a * b * c)));
                    return;
                }
            }
            a++;
            if (a + b + c > SPECIAL) {
                a = 0;
                b++;
            }
        }
    }
}
