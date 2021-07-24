package nl.bos;

public class PersistentLittleBugger {

    public static int bugger(int num) {
        if (String.valueOf(num).length() == 1) {
            return 0;
        }

        boolean isOneDigit = false;
        int index = 0;
        do {
            char[] chars = String.valueOf(num).toCharArray();
            int newNum = 1;
            for (char character : chars) {
                newNum *= Integer.parseInt(String.valueOf((character)));
            }
            num = newNum;
            if (String.valueOf(newNum).length() == 1) {
                isOneDigit = true;
            }
            index++;
        } while (!isOneDigit);
        return index;
    }
}