package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day10AdapterArray {

    public Day10AdapterArray() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day10AdapterArray");
        List<String> data = AdventReadInput.readData(is);

        List<Integer> integers = data.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
        List<Integer> jumpNumbers = convertToJumpNumbers(integers);
        jumpNumbers.add(3);//For your own built-in jolt adapter!

        int jumpSequence = 0;
        long result = 1;
        for (int jumpNumber : jumpNumbers) {
            if (jumpNumber == 3) {
                result *= getTribonacci(jumpSequence); //https://mathworld.wolfram.com/TribonacciNumber.html
                jumpSequence = 0;
                continue;
            }
            jumpSequence++;
        }


        System.out.print(String.format("Result = %d", result));
    }

    private int getTribonacci(int jumpNumber) {
        if (jumpNumber == 0 || jumpNumber == 1) {
            return 1;
        } else if (jumpNumber == 2) {
            return 2;
        } else if (jumpNumber == 3) {
            return 4;
        } else if (jumpNumber == 4) {
            return 7;
        } else if (jumpNumber == 5) {
            return 13;
        } else if (jumpNumber == 6) {
            return 24;
        } else if (jumpNumber == 7) {
            return 44;
        } else if (jumpNumber == 8) {
            return 81;
        } else if (jumpNumber == 9) {
            return 149;
        }
        return 0;
    }

    private List<Integer> convertToJumpNumbers(List<Integer> integers) {
        List<Integer> result = new ArrayList<>();
        int previousValue = 0;
        for (int value : integers) {
            result.add(value - previousValue);
            previousValue = value;
        }
        return result;
    }

    public static void main(String[] args) {
        new Day10AdapterArray();
    }
}
