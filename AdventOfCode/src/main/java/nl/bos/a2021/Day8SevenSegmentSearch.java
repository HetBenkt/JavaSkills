package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day8SevenSegmentSearch {

    public Day8SevenSegmentSearch() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day8SevenSegmentSearch");
        List<String> notes = AdventReadInput.readData(is);

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