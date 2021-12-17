package nl.bos.a2021;

import nl.bos.general.AdventReadInput;
import org.apache.commons.lang3.tuple.Pair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day8SevenSegmentSearch {

    public Day8SevenSegmentSearch() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day8SevenSegmentSearch");
        List<String> notes = AdventReadInput.readData(is);

        List<Pair<Integer, List<String>>> segmentsInfo = List.of(
                Pair.of(0, List.of("a", "b", "c", "e", "f", "g")),      //6
                Pair.of(1, List.of("c", "f")),                          //2*
                Pair.of(2, List.of("a", "c", "d", "e", "g")),           //5
                Pair.of(3, List.of("a", "c", "d", "f", "g")),           //5
                Pair.of(4, List.of("b", "c", "d", "f")),                //4*
                Pair.of(5, List.of("a", "b", "d", "f", "g")),           //5
                Pair.of(6, List.of("a", "b", "d", "e", "f", "g")),      //6
                Pair.of(7, List.of("a", "c", "f")),                     //3*
                Pair.of(8, List.of("a", "b", "c", "d", "e", "f", "g")), //7*
                Pair.of(9, List.of("a", "b", "c", "d", "f", "g"))       //6
        );

        List<NotesEntry> entries = new ArrayList<>();
        for (String entry : notes) {
            String[] split = entry.split("\\|");
            entries.add(new NotesEntry(split[0].split(" "), split[1].split(" ")));
        }

        long result = 0;
        for (NotesEntry entry : entries) {
            long count2 = Arrays.stream(entry.outputValues()).filter(s -> s.length() == 2).count();
            long count3 = Arrays.stream(entry.outputValues()).filter(s -> s.length() == 3).count();
            long count4 = Arrays.stream(entry.outputValues()).filter(s -> s.length() == 4).count();
            long count7 = Arrays.stream(entry.outputValues()).filter(s -> s.length() == 7).count();
            long counts = count2 + count3 + count4 + count7;
            result += counts;
        }

        System.out.printf("# of times digits 1, 4, 7, or 8 appear: %s", result);
    }

    public static void main(String[] args) {
        new Day8SevenSegmentSearch();
    }

    private record NotesEntry(String[] signalPatterns, String[] outputValues) {
    }
}