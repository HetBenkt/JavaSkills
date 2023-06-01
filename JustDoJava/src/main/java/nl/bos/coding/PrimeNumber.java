package nl.bos.coding;

public class PrimeNumber {

    private PrimeNumber() {}

    public static boolean run(int givenNumber) {
        if(givenNumber <= 1) {
            return false;
        }

        int nrOfFactors = 0;
        for (int i = 1; i <= givenNumber; i++) {
            if(givenNumber % i == 0) {
                nrOfFactors++;
                if(nrOfFactors > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
