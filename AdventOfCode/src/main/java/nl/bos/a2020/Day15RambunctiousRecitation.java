package nl.bos.a2020;

import nl.bos.general.AdventReadInput;
import org.apache.commons.lang3.time.StopWatch;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day15RambunctiousRecitation {

    public static final int YEAR = 30000000;

    public Day15RambunctiousRecitation() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day15RambunctiousRecitation");
        List<String> data = AdventReadInput.readData(is);

        List<Long> numbers = Stream.of(data.get(0).split(",")).map(Long::valueOf).collect(Collectors.toList());

        HashMap<Long, PlayedNumber> locationMap = new HashMap<>();
        int index = 0;
        for (long number : numbers) {
            locationMap.put(number, new PlayedNumber(index, -1));
            index++;
        }

        int turn = numbers.size();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        while (turn < YEAR) {
            long previousNumber = numbers.get(turn - 1);

            if (locationMap.containsKey(previousNumber) && locationMap.get(previousNumber).getPreviousLast() != -1) {
                // contains previousNumber
                long diff = locationMap.get(previousNumber).getLast() - locationMap.get(previousNumber).getPreviousLast();
                numbers.add(diff);
                if (locationMap.containsKey(diff)) {
                    // contains difference, last - previous last number
                    locationMap.put(diff, locationMap.get(diff).updatePositions(turn));
                } else {
                    locationMap.put(diff, new PlayedNumber(turn, -1));
                }
            } else {
                // doesn't contain previousNumber, add
                numbers.add(0L);
                locationMap.put(0L, locationMap.get(0L).updatePositions(turn));
            }
            turn++;
            if (turn % 1000000 == 0) {
                System.out.printf("%s sec. [turn %s]%n", stopWatch.getTime() / 1000, turn);
                stopWatch.reset();
                stopWatch.start();
            }
        }
        stopWatch.stop();
        System.out.printf("The number spoken = %d%n", numbers.get(YEAR - 1));
    }

    public static void main(String[] args) {
        new Day15RambunctiousRecitation();
    }

    private static class PlayedNumber {
        private int last;
        private int previousLast;

        private PlayedNumber(int last, int previousLast) {
            this.last = last;
            this.previousLast = previousLast;
        }

        private PlayedNumber updatePositions(int newLast) {
            previousLast = last;
            last = newLast;
            return new PlayedNumber(last, previousLast);
        }

        public int getLast() {
            return last;
        }

        public int getPreviousLast() {
            return previousLast;
        }
    }
}