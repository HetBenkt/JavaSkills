package nl.bos.a2023;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Day1Trebuchet {

    public Day1Trebuchet() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2023/Day1Trebuchet");
        List<String> calibrationData = AdventReadInput.readData(is);

        long sum = 0;

        for (String calibration : calibrationData) {
            calibration = digitize(calibration);
            int[] calibrationDigits = getDigitsOnly(calibration);
            sum += Integer.parseInt(calibrationDigits[0] + "" + calibrationDigits[calibrationDigits.length - 1]);
        }

        System.out.println(sum);
    }

    private String digitize(String calibration) {
        calibration = calibration.replace("one", "o1ne");
        calibration = calibration.replace("two", "t2wo");
        calibration = calibration.replace("three", "th3ree");
        calibration = calibration.replace("four", "f4our");
        calibration = calibration.replace("five", "f5ive");
        calibration = calibration.replace("six", "s6ix");
        calibration = calibration.replace("seven", "se7ven");
        calibration = calibration.replace("eight", "ei8ght");
        calibration = calibration.replace("nine", "n9ine");
        return calibration;
    }

    private int[] getDigitsOnly(String calibration) {
        StringBuilder digits = new StringBuilder();
        for (char calibrationValue : calibration.toCharArray()) {
            int value = Character.getNumericValue(calibrationValue);
            if (value >= 0 && value <= 9) {
                digits.append(value).append(";");
            }
        }
        return Arrays.stream(String.valueOf(digits).split(";")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        new Day1Trebuchet();
    }
}
