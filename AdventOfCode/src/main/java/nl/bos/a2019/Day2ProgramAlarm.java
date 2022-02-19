package nl.bos.a2019;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Day2ProgramAlarm {

    private final int[] gravityAssistProgram;

    public Day2ProgramAlarm() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2019/Day2ProgramAlarm");
        ArrayList<String> intCode = AdventReadInput.readData(is);
        gravityAssistProgram = Arrays.stream(intCode.get(0).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        gravityAssistProgram[1] = 12;
        gravityAssistProgram[2] = 2;

        for (int i = 0; i < gravityAssistProgram.length; i = i + 4) {
            int[] set = new int[4];
            set[0] = gravityAssistProgram[i];
            set[1] = gravityAssistProgram[i + 1];
            set[2] = gravityAssistProgram[i + 2];
            set[3] = gravityAssistProgram[i + 3];

            switch (set[0]) {
                case 1 -> add(set);
                case 2 -> multiply(set);
                case 99 -> exit();
            }
        }
    }

    private void exit() {
        System.out.println(gravityAssistProgram[0]);
        System.exit(0);
    }

    private void multiply(int[] set) {
        gravityAssistProgram[set[3]] = gravityAssistProgram[set[1]] * gravityAssistProgram[set[2]];
    }

    private void add(int[] set) {
        gravityAssistProgram[set[3]] = gravityAssistProgram[set[1]] + gravityAssistProgram[set[2]];
    }

    public static void main(String[] args) {
        new Day2ProgramAlarm();
    }

}
