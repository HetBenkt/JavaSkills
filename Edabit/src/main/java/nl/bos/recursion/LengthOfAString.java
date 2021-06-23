package nl.bos.recursion;

public class LengthOfAString {

    public static int length(String str) {
        if (str.equals("")) {
            return 0;
        }
        return length(str.substring(1)) + 1;
    }
}
