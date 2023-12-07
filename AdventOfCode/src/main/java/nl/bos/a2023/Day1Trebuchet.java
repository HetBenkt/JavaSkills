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
            int[] calibrationDigits = getDigitsOnly(calibration);
            sum += Integer.parseInt(calibrationDigits[0] + "" + calibrationDigits[calibrationDigits.length - 1]);
        }

        System.out.println(sum);
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
