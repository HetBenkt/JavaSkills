package nl.bos.a2019;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Day2ProgramAlarm {

    private final static int OUTPUT = 19690720;
    private int[] gravityAssistProgram;

    public Day2ProgramAlarm() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2019/Day2ProgramAlarm");
        ArrayList<String> intCode = AdventReadInput.readData(is);
        gravityAssistProgram = Arrays.stream(intCode.get(0).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] gravityAssistProgramBackup = Arrays.stream(gravityAssistProgram).toArray();

        int noun = 0;
        int verb = 0;

        while (true) {
            for (int i = 0; i < gravityAssistProgram.length; i = i + 4) {
                int[] set = new int[4];
                set[0] = gravityAssistProgram[i];
                set[1] = gravityAssistProgram[i + 1];
                set[2] = gravityAssistProgram[i + 2];
                set[3] = gravityAssistProgram[i + 3];

                switch (set[0]) {
                    case 1 -> add(set);
                    case 2 -> multiply(set);
                    case 99 -> {
                        if (gravityAssistProgram[0] == OUTPUT) {
                            System.out.println((noun * 100) + verb);
                            System.exit(0);
                        }
                        if (gravityAssistProgram[0] > OUTPUT) {
                            noun = 0;
                            verb++;
                            gravityAssistProgramBackup[2] = verb;
                        }
                        i = 0;
                        noun++;
                        gravityAssistProgramBackup[1] = noun;
                        gravityAssistProgram = Arrays.stream(gravityAssistProgramBackup).toArray();
                    }
                }
            }
        }
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
