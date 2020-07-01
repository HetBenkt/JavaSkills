package nl.bos.kyu5;

import java.util.HashMap;
import java.util.Map;

public class SimpleAssembler {
    static Map<String, Integer> register = new HashMap<>();

    public static Map<String, Integer> interpret(String[] program) {
        for (int i = 0; i < program.length; i++) {
            String instruction = program[i];

            switch (instruction.substring(0, 3)) {
                case "mov":
                    doMove(instruction.substring(4));
                    break;
                case "inc":
                    doInc(instruction.substring(4));
                    break;
                case "dec":
                    doDec(instruction.substring(4));
                    break;
                case "jnz":
                    String[] split = instruction.substring(4).split(" ");
                    String registerLocation = split[0];

                    Integer registerJumpValue = 0;
                    try {
                        registerJumpValue = Integer.parseInt(split[1]);
                    } catch (NumberFormatException nfo) {
                        registerJumpValue = register.get(split[1]);
                    }

                    if (register.get(registerLocation) == 0) {
                        break;
                    }
                    i--;
                    i += registerJumpValue;
                    break;
                default:
            }

            register.forEach((key, value) -> System.out.println(key + ":" + value));
        }

        return register;
    }

    private static void doDec(String regLocation) {
        Integer integer = register.get(regLocation);
        integer--;
        register.put(regLocation, integer);
    }

    private static void doInc(String regLocation) {
        Integer integer = register.get(regLocation);
        integer++;
        register.put(regLocation, integer);
    }

    private static void doMove(String moveInstruction) {
        String[] split = moveInstruction.split(" ");
        String registerLocation = split[0];
        String registerValue = split[1];
        Integer value = 0;
        try {
            value = Integer.parseInt(registerValue);
        } catch (NumberFormatException nfo) {
            value = register.get(registerValue);
        }
        register.put(registerLocation, value);
    }
}
