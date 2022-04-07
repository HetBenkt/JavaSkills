package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day2PasswordPhilosophy {

    public static void main(String[] args) {
        new Day2PasswordPhilosophy();
    }

    public Day2PasswordPhilosophy() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day2PasswordPhilosophy");
        List<String> data = AdventReadInput.readData(is);

        int correctPasswords = 0;

        for (String line : data) {
            String[] split = line.split(" ");
            String[] minMax = split[0].split("-");
            correctPasswords += isPasswordCorrect(split[2], split[1].substring(0, 1).charAt(0), Integer.parseInt(minMax[0]) - 1, Integer.parseInt(minMax[1]) - 1);
        }
        System.out.println(String.format("No. of correct passwords: %s", correctPasswords));
    }

    private int isPasswordCorrect(String password, char character, int index1, int index2) {
        char char1 = password.charAt(index1);
        char char2 = password.charAt(index2);

        if (char1 == character && char2 == character) {
            return 0;
        } else if (char1 == character || char2 == character) {
            return 1;
        }
        return 0;
    }
}
