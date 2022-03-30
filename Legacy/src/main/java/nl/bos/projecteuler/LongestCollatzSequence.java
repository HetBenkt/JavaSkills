package nl.bos.projecteuler;

import java.text.MessageFormat;

public class LongestCollatzSequence {
    private static int maxTerms;

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        for (int i = 113383; i < 1000000; i++) {
            int terms = 1;
            long sequenceNr = i;
            do {
                terms++;
                if (sequenceNr % 2 == 0) {
                    //Even number
                    sequenceNr = sequenceNr / 2;
                } else {
                    //Odd number
                    sequenceNr = (sequenceNr * 3) + 1;
                    //At term 122 it will be negative for an INT -> (827370449 * 3) + 1 = -1812855948
                    //MAX_VALUE of an INT is 2147483647
                    //sequenceNr should be a long!
                }
            } while (sequenceNr != 1);
            if (terms > maxTerms) {
                maxTerms = terms;
                System.out.println(MessageFormat.format("Max. term for {0}: {1}", i, maxTerms));
            }
        }
        System.out.println(MessageFormat.format("Result {0}", maxTerms));
    }
}
