package nl.bos.strings;

public class PersonalIdNumber {
    public static boolean validate(String pin) {
        if (pin.isEmpty() || pin.contains(" ") || !(pin.length() == 4 || pin.length() == 6)) {
            return false;
        } else return onlyNumericChars(pin);
    }

    private static boolean onlyNumericChars(String pin) {
        char[] chars = pin.toCharArray();
        for (char character : chars) {
            try {
                Integer.parseInt(String.valueOf(character));
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }
}
