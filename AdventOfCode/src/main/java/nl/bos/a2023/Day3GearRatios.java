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

        int sum = 0;
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[0].length; j++) {
                //skip '.' and 0-9
                if(twoDArray[i][j] != 46 && (twoDArray[i][j] < 48 || twoDArray[i][j] > 57)) {
                    System.out.println(twoDArray[i][j]);
                    int sumOfAdjacentNumbers = getSumOfAdjacentNumbers(twoDArray, i, j);
                    sum += sumOfAdjacentNumbers;
                }
            }
        }

        System.out.println(sum);
    }

    private int getSumOfAdjacentNumbers(char[][] twoDArray, int i, int j) {
        int result = 0;
        char[] adjacentFieldsFirstRow = new char[3];
        char[] adjacentFieldsSecondRow = new char[2];
        char[] adjacentFieldsThirdRow = new char[3];
        //first row
        adjacentFieldsFirstRow[0] = twoDArray[i-1][j-1];
        adjacentFieldsFirstRow[1] = twoDArray[i-1][j-0];
        adjacentFieldsFirstRow[2] = twoDArray[i-1][j+1];
        //second row
        adjacentFieldsSecondRow[0] = twoDArray[i-0][j-1];
        adjacentFieldsSecondRow[1] = twoDArray[i-0][j+1];
        //third row
        adjacentFieldsThirdRow[0] = twoDArray[i+1][j-1];
        adjacentFieldsThirdRow[1] = twoDArray[i+1][j-0];
        adjacentFieldsThirdRow[2] = twoDArray[i+1][j+1];

        for (char c : adjacentFieldsFirstRow) {
            if(c != 46) { //so, when no '.'
                String line = getLineFromTwoDArray(twoDArray, i - 1);
                System.out.println(line);
                break;
            }
        }

        for (char c : adjacentFieldsSecondRow) {
            if(c != 46) { //so, when no '.'
                String line = getLineFromTwoDArray(twoDArray, i);
                System.out.println(line);
                break;
            }
        }

        for (char c : adjacentFieldsThirdRow) {
            if(c != 46) { //so, when no '.'
                String line = getLineFromTwoDArray(twoDArray, i+1);
                System.out.println(line);
                break;
            }
        }

        return result;
    }

    private String getLineFromTwoDArray(char[][] twoDArray, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < twoDArray[i].length; j++) {
            stringBuilder.append(twoDArray[i][j]);
        }
        return String.valueOf(stringBuilder);
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
