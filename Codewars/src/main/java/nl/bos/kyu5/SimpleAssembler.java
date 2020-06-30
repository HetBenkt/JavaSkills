package nl.bos.kyu5;

import java.util.HashMap;
import java.util.Map;

public class SimpleAssembler {
    static Map<String, Integer> register = new HashMap<>();

    public static Map<String, Integer> interpret(String[] program) {
        for (String instruction : program) {
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
                    doJnz(instruction.substring(4));
                    break;
                default:
            }
        }

        return register;
    }

    private static void doJnz(String jnzInstruction) {

    }

    private static void doDec(String decInstruction) {

    }

    private static void doInc(String incInstruction) {

    }

    private static void doMove(String moveInstruction) {
        String[] split = moveInstruction.split(" ");
        String registerLocation = split[0];
        Integer registerValue = Integer.parseInt(split[1]);
        register.put(registerLocation, registerValue);
    }
}
