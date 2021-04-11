package nl.bos.a2020;

import nl.bos.general.AdventReadInput;
import org.apache.commons.lang3.time.StopWatch;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day15RambunctiousRecitation {

    public static final int YEAR = 30000000; //30000000

    public Day15RambunctiousRecitation() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day15RambunctiousRecitation");
        List<String> data = AdventReadInput.readData(is);

        List<Long> startNumbers = Stream.of(data.get(0).split(",")).map(Long::valueOf).collect(Collectors.toList());
        List<Long> numbers = new ArrayList<>();
        numbers.addAll(startNumbers);

        Map<Long, Long> countMap = new HashMap<>();
        for (long number : numbers) {
            countMap.put(number, (countMap.get(number) == null) ? 1L : countMap.get(number) + 1L);
        }

        int turn = numbers.size();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        while (turn < YEAR) {
            long lastSpokenNr = numbers.get(numbers.size() - 1);
            long count = countMap.get(lastSpokenNr);
            //long count = numbers.parallelStream().filter(c -> c == lastSpokenNr).count();
            //long count = numbers.stream().filter(c -> c == lastSpokenNr).count();
            //long count = getCount(numbers, lastSpokenNr);
            if (count == 1) {
                numbers.add(0L);
                countMap.put(0L, (countMap.get(0L) == null) ? 1L : countMap.get(0L) + 1L);
            } else if (count >= 2) {
                List<Integer> indexes = getIndexes(numbers, lastSpokenNr);
                long number = ((indexes.get(indexes.size() - 2) + 1) - (indexes.get(indexes.size() - 1) + 1));
                numbers.add(number);
                countMap.put(number, (countMap.get(number) == null) ? 1L : countMap.get(number) + 1L);
            }
            turn++;
            if (turn % 100000 == 0) {
                System.out.println(String.format("%s sec. [turn %s]", stopWatch.getTime() / 1000, turn));
                stopWatch.reset();
                stopWatch.start();
            }
        }
        //System.out.println(String.format("%s", stopWatch.getTime()));
        stopWatch.stop();
        System.out.println(String.format("The number spoken = %d", numbers.get(YEAR - 1)));
    }

    private long getCount(List<Long> numbers, long lastSpokenNr) {
        List<Long> numbersTemp = new ArrayList<>();
        numbersTemp.addAll(numbers);
        Collections.sort(numbersTemp);
        long first = numbersTemp.indexOf(lastSpokenNr);
        long last = numbersTemp.lastIndexOf(lastSpokenNr);
        return (last - first) + 1;
    }

    private List<Integer> getIndexes(List<Long> numbers, long lastSpokenNr) {
        List<Integer> matchingIndices = new ArrayList<>();

        int lastIndexOf = numbers.lastIndexOf(lastSpokenNr);
        matchingIndices.add(lastIndexOf);
        numbers.set(lastIndexOf, -1L);

        int lastIndexOf1 = numbers.lastIndexOf(lastSpokenNr);
        matchingIndices.add(lastIndexOf1);
        numbers.set(lastIndexOf, lastSpokenNr);

        return matchingIndices;
    }

    public static void main(String[] args) {
        new Day15RambunctiousRecitation();
    }
}