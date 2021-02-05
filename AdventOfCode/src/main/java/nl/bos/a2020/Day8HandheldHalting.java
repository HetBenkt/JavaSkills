package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day8HandheldHalting {

    public Day8HandheldHalting() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day8HandheldHalting");
        List<String> bootCode = AdventReadInput.readData(is);

        boolean run = true;
        int accumulator = 0;
        int index = 0;
        List<Integer> indexes = new ArrayList<>();

        while (run) {
            String[] split = bootCode.get(index).split(" ");
            String operation = split[0];
            int argument = Integer.parseInt(split[1]);
            switch (operation) {
                case "acc":
                    accumulator += argument;
                    index++;
                    break;
                case "jmp":
                    index += argument;
                    break;
                case "nop":
                    index++;
                    break;
                default:
                    break;
            }
            if (!indexes.contains(index)) {
                indexes.add(index);
            } else {
                run = false;
            }
        }

        System.out.println(String.format("Value of the accumulator is: %d", accumulator));
    }

    public static void main(String[] args) {
        new Day8HandheldHalting();
    }
}
