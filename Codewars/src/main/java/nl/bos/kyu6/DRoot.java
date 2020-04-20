package nl.bos.kyu6;

class DRoot {

    private DRoot() {
    }

    static int digitalRoot(int n) {
        do {
            n = calcResult(n);
        } while (n >= 10);

        return n;
    }

    private static int calcResult(int n) {
        String number = String.valueOf(n);

        char[] digits = number.toCharArray();
        int result = 0;
        for (char digit : digits) {
            int value = Integer.parseInt(String.valueOf(digit));
            result += value;
        }
        return result;
    }
}
