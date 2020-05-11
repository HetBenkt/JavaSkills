package nl.bos.kyu5;

public class HumanReadableTime {

    public static final int ONE_MINUTE = 60;
    public static final int ONE_HOUR = ONE_MINUTE * ONE_MINUTE;
    public static final int ONE_DAY = ONE_HOUR * 24;

    public static String makeReadable(int seconds) {
        if (seconds > 359999) {
            return "Wrong input";
        }

        int numberOfDays = seconds / ONE_DAY;
        int numberOfHours = (seconds % ONE_DAY) / ONE_HOUR;
        int numberOfMinutes = ((seconds % ONE_DAY) % ONE_HOUR) / ONE_MINUTE;
        int numberOfSeconds = ((seconds % ONE_DAY) % ONE_HOUR) % ONE_MINUTE;

        return String.format("%02d:%02d:%02d", numberOfHours + (numberOfDays * 24), numberOfMinutes, numberOfSeconds);
    }
}
