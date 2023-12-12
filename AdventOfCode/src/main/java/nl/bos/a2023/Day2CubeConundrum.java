package nl.bos.a2023;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Day2CubeConundrum {

    public Day2CubeConundrum() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2023/Day2CubeConundrum");
        List<String> games = AdventReadInput.readData(is);

        int sum = 0;
        boolean addGameToSum;

        for (String game : games) {
            addGameToSum = true;
            List<String> sets = Arrays.stream(
                            game.substring(game.indexOf(":") + 1).trim().split(";"))
                    .toList().stream().map(String::trim).toList();
            nextGame:
            for (String set : sets) {
                List<String> cubes = Arrays.stream(set.split(","))
                        .toList().stream().map(String::trim).toList();
                for (String cube : cubes) {
                    String[] split = cube.split(" ");
                    int numberOfCubes = Integer.parseInt(split[0]);
                    String color = split[1];
                    if (!doesItFit(numberOfCubes, color)) {
                        addGameToSum = false;
                        break nextGame;
                    }
                }
            }
            if (addGameToSum) {
                sum += Integer.parseInt(game.substring(5, game.indexOf(":")));
            }
        }

        System.out.println(sum);

    }

    public static void main(String[] args) {
        new Day2CubeConundrum();
    }

    private boolean doesItFit(int numberOfCubes, String color) {
        return switch (color) {
            case "red" -> numberOfCubes <= 12;
            case "green" -> numberOfCubes <= 13;
            case "blue" -> numberOfCubes <= 14;
            default -> false;
        };
    }
}
