package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.*;

public class Day12RainRisk {

    public Day12RainRisk() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day12RainRisk");
        List<String> instructions = AdventReadInput.readData(is);

        HashMap<State, Integer> directionsFerry = new HashMap<>();
        directionsFerry.put(State.NORTH, 0);
        directionsFerry.put(State.SOUTH, 0);
        directionsFerry.put(State.EAST, 0);
        directionsFerry.put(State.WEST, 0);
        StateObject ferry = new StateObject(directionsFerry);

        HashMap<State, Integer> directionsWaypoint = new HashMap<>();
        directionsWaypoint.put(State.NORTH, 1);
        directionsWaypoint.put(State.SOUTH, 0);
        directionsWaypoint.put(State.EAST, 10);
        directionsWaypoint.put(State.WEST, 0);
        StateObject waypoint = new StateObject(directionsWaypoint);

        for (String instruction : instructions) {
            char action = instruction.charAt(0);
            int value = Integer.parseInt(instruction.substring(1));

            switch (action) {
                case 'R':
                    waypoint.updateCardinalDirection(value);
                    break;
                case 'L':
                    waypoint.updateCardinalDirection(-value);
                    break;
                case 'F':
                    ferry.forward(value, waypoint);
                    break;
                case 'N':
                    waypoint.forward(State.NORTH, value);
                    break;
                case 'S':
                    waypoint.forward(State.SOUTH, value);
                    break;
                case 'E':
                    waypoint.forward(State.EAST, value);
                    break;
                case 'W':
                    waypoint.forward(State.WEST, value);
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

    private static class StateObject {

        private final HashMap<State, Integer> directions;

        public StateObject(HashMap<State, Integer> directions) {
            this.directions = directions;
        }

        public HashMap<State, Integer> getDirections() {
            return directions;
        }

        public void updateCardinalDirection(int value) {
            HashMap<State, Integer> directionsTemp = new HashMap<>();
            directionsTemp.putAll(directions);

            switch (value) {
                //Rotate right
                case 90:
                    for (Map.Entry<State, Integer> entry : directionsTemp.entrySet()) {
                        State entryKey = entry.getKey();
                        Integer entryValue = entry.getValue();
                        directions.put(entryKey.next(), entryValue);
                    }
                    break;
                case 180:
                    for (Map.Entry<State, Integer> entry : directionsTemp.entrySet()) {
                        State entryKey = entry.getKey();
                        Integer entryValue = entry.getValue();
                        directions.put(entryKey.next().next(), entryValue);
                    }
                    break;
                case 270:
                    for (Map.Entry<State, Integer> entry : directionsTemp.entrySet()) {
                        State entryKey = entry.getKey();
                        Integer entryValue = entry.getValue();
                        directions.put(entryKey.next().next().next(), entryValue);
                    }
                    break;
                //Rotate left
                case -90:
                    for (Map.Entry<State, Integer> entry : directionsTemp.entrySet()) {
                        State entryKey = entry.getKey();
                        Integer entryValue = entry.getValue();
                        directions.put(entryKey.prev(), entryValue);
                    }
                    break;
                case -180:
                    for (Map.Entry<State, Integer> entry : directionsTemp.entrySet()) {
                        State entryKey = entry.getKey();
                        Integer entryValue = entry.getValue();
                        directions.put(entryKey.prev().prev(), entryValue);
                    }
                    break;
                case -270:
                    for (Map.Entry<State, Integer> entry : directionsTemp.entrySet()) {
                        State entryKey = entry.getKey();
                        Integer entryValue = entry.getValue();
                        directions.put(entryKey.prev().prev().prev(), entryValue);
                    }
                    break;
                default:
                    break;
            }
        }

        public void forward(int value, StateObject waypoint) {
            HashMap<State, Integer> directions = waypoint.getDirections();
            for (Map.Entry<State, Integer> entry : directions.entrySet()) {
                State entryKey = entry.getKey();
                Integer entryValue = entry.getValue();
                if (entryValue != 0) {
                    this.directions.put(entryKey, this.directions.get(entryKey) + (entryValue * value) - this.directions.get(entryKey.next().next()));
                    this.directions.put(entryKey.next().next(), 0);
                }
            }
            System.out.print(Arrays.asList(this.directions));
            System.out.println(Arrays.asList(directions));
        }

        public void forward(State state, int value) {
            directions.put(state, directions.get(state) + value);
            System.out.println(Collections.singletonList(directions));
        }
    }
}