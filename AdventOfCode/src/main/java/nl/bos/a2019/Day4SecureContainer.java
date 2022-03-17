package nl.bos.a2019;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;

public class Day4SecureContainer {

    public Day4SecureContainer() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2019/Day4SecureContainer");
        ArrayList<String> input = AdventReadInput.readData(is);
        String[] split = input.get(0).split("-");
        int result = 0;

        for (int i = Integer.parseInt(split[0]); i <= Integer.parseInt(split[1]); i++) {
            String[] numbers = String.valueOf(i).split("");
            boolean containsSame = false;
            for (int j = 0; j < numbers.length; j++) {
                if (j < 5 && !(Integer.parseInt(numbers[j]) <= Integer.parseInt(numbers[j + 1]))) {
                    break;
                }
                if (j < 5 && Integer.parseInt(numbers[j]) == Integer.parseInt(numbers[j + 1])) {
                    containsSame = true;
                }
                if (j == 5 && containsSame) {
                    result++;
                    containsSame = false;
                    //System.out.println(i);
                }
            }
        }

        System.out.println("Count of different passwords: " + result);
    }

    public static void main(String[] args) {
        new Day4SecureContainer();
    }
}
