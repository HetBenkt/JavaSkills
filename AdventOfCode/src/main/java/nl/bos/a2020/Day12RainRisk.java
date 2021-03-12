package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Day12RainRisk {

    public Day12RainRisk() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day12RainRisk");
        List<String> instructions = AdventReadInput.readData(is);

        Ferry ferry = new Ferry();

        for (String instruction : instructions) {
            char action = instruction.charAt(0);
            int value = Integer.parseInt(instruction.substring(1));

            switch (action) {
                case 'R':
                    ferry.updateCardinalDirection(value);
                    break;
                case 'L':
                    ferry.updateCardinalDirection(-value);
                    break;
                case 'F':
                    ferry.forward(value);
                    break;
                case 'N':
                    ferry.forward(State.NORTH, value);
                    break;
                case 'S':
                    ferry.forward(State.SOUTH, value);
                    break;
                case 'E':
                    ferry.forward(State.EAST, value);
                    break;
                case 'W':
                    ferry.forward(State.WEST, value);
                    break;
                default:
                    break;
            }
        }

        HashMap<State, Integer> directions = ferry.getDirections();
        System.out.println(String.format("The Manhattan distance = %d", Math.abs(directions.get(State.WEST) - directions.get(State.EAST)) + Math.abs(directions.get(State.NORTH) - directions.get(State.SOUTH))));
    }

    public static void main(String[] args) {
        new Day12RainRisk();
    }

    public enum State {
        EAST, SOUTH, WEST, NORTH;

        public static final State[] values = values();

        public State prev() {
            return values[(ordinal() - 1 + values.length) % values.length];
        }

        public State next() {
            return values[(ordinal() + 1) % values.length];
        }
    }

    private static class Ferry {

        private final HashMap<State, Integer> directions;
        private State currentCardinalDirection;

        public Ferry() {
            currentCardinalDirection = State.EAST;
            directions = new HashMap<>();
            directions.put(State.NORTH, 0);
            directions.put(State.SOUTH, 0);
            directions.put(State.EAST, 0);
            directions.put(State.WEST, 0);
        }

        public HashMap<State, Integer> getDirections() {
            return directions;
        }

        public void updateCardinalDirection(int value) {
            switch (value) {
                //Rotate right
                case 90:
                    currentCardinalDirection = currentCardinalDirection.next();
                    break;
                case 180:
                    currentCardinalDirection = currentCardinalDirection.next();
                    currentCardinalDirection = currentCardinalDirection.next();
                    break;
                case 270:
                    currentCardinalDirection = currentCardinalDirection.next();
                    currentCardinalDirection = currentCardinalDirection.next();
                    currentCardinalDirection = currentCardinalDirection.next();
                    break;
                //Rotate left
                case -90:
                    currentCardinalDirection = currentCardinalDirection.prev();
                    break;
                case -180:
                    currentCardinalDirection = currentCardinalDirection.prev();
                    currentCardinalDirection = currentCardinalDirection.prev();
                    break;
                case -270:
                    currentCardinalDirection = currentCardinalDirection.prev();
                    currentCardinalDirection = currentCardinalDirection.prev();
                    currentCardinalDirection = currentCardinalDirection.prev();
                    break;
                default:
                    break;
            }
        }

        public void forward(int value) {
            directions.put(currentCardinalDirection, directions.get(currentCardinalDirection) + value);
            System.out.println(Arrays.asList(directions));
        }

        public void forward(State state, int value) {
            directions.put(state, directions.get(state) + value);
            System.out.println(Collections.singletonList(directions));
        }
    }
}