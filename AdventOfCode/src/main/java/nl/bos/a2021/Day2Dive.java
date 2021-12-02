package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day2Dive {

    public Day2Dive() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day2Dive");
        List<String> commandsInput = AdventReadInput.readData(is);

        int depth = 0;
        int horizontalPosition = 0;
        int aim = 0;

        List<Command> commands = new ArrayList<>();
        for (String command : commandsInput) {
            String[] commandSplit = command.split(" ");
            commands.add(new Command(EDirections.valueOf(commandSplit[0]), Integer.parseInt(commandSplit[1])));
        }

        for (Command command : commands) {
            if (command.direction.equals(EDirections.forward)) {
                horizontalPosition += command.size;
                depth += (aim * command.size);
            }
            if (command.direction.equals(EDirections.down)) {
                aim += command.size;
            }
            if (command.direction.equals(EDirections.up)) {
                aim -= command.size;
            }
        }

        System.out.println(String.format("Multiply final horizontal position by final depth: %s", (depth * horizontalPosition)));
    }

    public static void main(String[] args) {
        new Day2Dive();
    }

    private enum EDirections {forward, down, up}

    private record Command(EDirections direction, int size) {
    }
}
