package nl.bos.kyu6;

class Persist {

    private static int atomicIndex = 0;

    private Persist() {
    }

    static int persistence(long n) {
        if (n < 10) {
            return atomicIndex;
        }

        int index = recursivePersistency(n);
        atomicIndex = 0;
        return index;
    }

    private static int recursivePersistency(long n) {
        String number = String.valueOf(n);
        char[] digits = number.toCharArray();
        long nextValue = 1;
        for (char digit : digits) {
            nextValue *= Integer.parseInt(String.valueOf(digit));
        }
        atomicIndex++;
        if (nextValue > 9) {
            recursivePersistency(nextValue);
        }
        return atomicIndex;
    }
}
