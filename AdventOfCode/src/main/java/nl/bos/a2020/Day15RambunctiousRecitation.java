package nl.bos.a2020;

import nl.bos.general.AdventReadInput;
import org.apache.commons.lang3.time.StopWatch;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day15RambunctiousRecitation {

    public static final int YEAR = 30000000;

    public Day15RambunctiousRecitation() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day15RambunctiousRecitation");
        List<String> data = AdventReadInput.readData(is);

        List<Long> startNumbers = Stream.of(data.get(0).split(",")).map(Long::valueOf).collect(Collectors.toList());
        List<Long> numbers = new ArrayList<>();
        numbers.addAll(startNumbers);

        int turn = numbers.size();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        while (turn < YEAR) {
            long lastSpokenNr = numbers.get(numbers.size() - 1);
            long count = numbers.parallelStream().filter(c -> c == lastSpokenNr).count();
            if (count == 1) {
                numbers.add(0L);
            } else if (count >= 2) {
                List<Integer> indexes = getIndexes(numbers, lastSpokenNr);
                numbers.add((long) ((indexes.get(indexes.size() - 2) + 1) - (indexes.get(indexes.size() - 1) + 1)));
            }
            turn++;
            if (turn % 100000 == 0) {
                stopWatch.stop();
                System.out.println(String.format("%s sec. [turn %s]", stopWatch.getTime() / 1000, turn));
                stopWatch.reset();
                stopWatch.start();
            }
        }

        System.out.println(String.format("The 2020th number spoken = %d", numbers.get(YEAR - 1)));
    }

    private List<Integer> getIndexes(List<Long> numbers, long lastSpokenNr) {
        List<Integer> matchingIndices = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            long element = numbers.get(i);

            if (lastSpokenNr == element) {
                matchingIndices.add(i);
            }
            if (matchingIndices.size() == 2) {
                return matchingIndices;
            }
        }
        return matchingIndices;
    }

    public static void main(String[] args) {
        new Day15RambunctiousRecitation();
    }
}