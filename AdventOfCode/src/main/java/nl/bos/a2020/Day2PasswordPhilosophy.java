package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;

public class Day2PasswordPhilosophy {

    public Day2PasswordPhilosophy() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day2PasswordPhilosophy");
        ArrayList<String> data = AdventReadInput.readData(is);

        int correctPasswords = 0;

        for (String line : data) {
            String[] split = line.split(" ");
            String[] minMax = split[0].split("-");
            correctPasswords += isPasswordCorrect(split[2], split[1].substring(0, 1).charAt(0), Integer.parseInt(minMax[0]), Integer.parseInt(minMax[1]));
        }
        System.out.println(String.format("No. of correct passwords: %s", correctPasswords));
    }

    public static void main(String[] args) {
        new Day2PasswordPhilosophy();
    }

    private int isPasswordCorrect(String password, char character, int min, int max) {
        long count = password.chars().filter(ch -> ch == character).count();
        if (count >= min && count <= max) {
            return 1;
        }
        return 0;
    }
}
