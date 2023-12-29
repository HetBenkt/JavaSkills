package nl.bos.a2023;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day3GearRatios {

    public Day3GearRatios() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2023/Day3GearRatios");
        List<String> data = AdventReadInput.readData(is);

        String emptyRow = data.get(0).replaceAll(".", ".");

        List<String> engineSchematic = addEmptyPerimeter(data, emptyRow);
        char[][] twoDArray = convertTwoDArray(engineSchematic);

        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[0].length; j++) {
                //skip '.' and 0-9
                if(twoDArray[i][j] != 46 && (twoDArray[i][j] < 48 || twoDArray[i][j] > 57)) {
                    System.out.println(twoDArray[i][j]);
                }
            }

        }

        System.out.println("");
    }

    public static void main(String[] args) {
        new Day3GearRatios();
    }

    private char[][] convertTwoDArray(List<String> engineSchematic) {
        char[][] result = new char[engineSchematic.size()][engineSchematic.size()];
        int index = 0;
        for (String line : engineSchematic) {
            char[] charArray = line.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                result[index][i] = charArray[i];

            }
            index++;
        }
        return result;
    }

    private List<String> addEmptyPerimeter(List<String> data, String emptyRow) {
        List<String> result = new ArrayList<>();
        result.add(String.format("%s%s%s", ".", emptyRow, "."));
        for (String row : data) {
            result.add(String.format("%s%s%s", ".", row, "."));
        }
        result.add(String.format("%s%s%s", ".", emptyRow, "."));
        return result;
    }
}
