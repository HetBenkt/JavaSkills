package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day8HandheldHalting {

    public static final String JMP = "jmp";
    public static final String NOP = "nop";
    public static final String ACC = "acc";

    public Day8HandheldHalting() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day8HandheldHalting");
        List<String> originalBootCode = AdventReadInput.readData(is);

        int codeLineIndex = 0;
        for (String codeLine : originalBootCode) {
            List<String> changedBootCode = new ArrayList<>();
            changedBootCode.addAll(originalBootCode);
            String[] splitCodeLine = codeLine.split(" ");
            switch (splitCodeLine[0]) {
                case JMP:
                    changedBootCode.set(codeLineIndex, String.format("%s %s", NOP, splitCodeLine[1]));
                    break;
                case NOP:
                    changedBootCode.set(codeLineIndex, String.format("%s %s", JMP, splitCodeLine[1]));
                    break;
                default:
                    break;
            }
            codeLineIndex++;

            runCode(changedBootCode);
        }
    }

    private void runCode(List<String> bootCode) {
        boolean run = true;
        int accumulator = 0;
        int index = 0;
        List<Integer> indexes = new ArrayList<>();

        while (run) {
            String[] split = bootCode.get(index).split(" ");
            String operation = split[0];
            int argument = Integer.parseInt(split[1]);
            switch (operation) {
                case ACC:
                    accumulator += argument;
                    index++;
                    break;
                case JMP:
                    index += argument;
                    break;
                case NOP:
                    index++;
                    break;
                default:
                    break;
            }

            if (!indexes.contains(index)) {
                indexes.add(index);
                if (index == bootCode.size()) {
                    System.out.println(String.format("Value of the accumulator is: %d", accumulator));
                    System.exit(0);
                }
            } else {
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        new Day8HandheldHalting();
    }
}
