package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3BinaryDiagnostic {

    public Day3BinaryDiagnostic() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day3BinaryDiagnostic");
        List<String> diagnosticReport = AdventReadInput.readData(is);
        List<String> oxygenGeneratorRating = new ArrayList<>();
        List<String> co2ScrubberRating = new ArrayList<>();

        char oxygenGeneratorChar;
        char co2ScrubberChar;
        if (diagnosticReport.stream().filter(reportRow -> reportRow.charAt(0) == '0').count() > diagnosticReport.stream().filter(reportRow -> reportRow.charAt(0) == '1').count()) {
            oxygenGeneratorChar = '0';
            co2ScrubberChar = '1';
        } else {
            oxygenGeneratorChar = '1';
            co2ScrubberChar = '0';
        }

        oxygenGeneratorRating.addAll(diagnosticReport.stream().filter(s -> s.charAt(0) == oxygenGeneratorChar).collect(Collectors.toList()));
        co2ScrubberRating.addAll(diagnosticReport.stream().filter(s -> s.charAt(0) == co2ScrubberChar).collect(Collectors.toList()));

        int oxygenGeneratorValue = calcOxygen(diagnosticReport, oxygenGeneratorRating);
        int co2ScrubberValue = calcCo2(diagnosticReport, co2ScrubberRating);

        System.out.printf("Power consumption of the submarine: %s", (oxygenGeneratorValue * co2ScrubberValue));
    }

    private int calcOxygen(List<String> diagnosticReport, List<String> ratings) {
        for (int i = 1; i < diagnosticReport.get(0).length(); i++) {
            int finalI = i;
            if (ratings.stream().filter(reportRow -> reportRow.charAt(finalI) == '0').count() > ratings.stream().filter(reportRow -> reportRow.charAt(finalI) == '1').count()) {
                int size = ratings.size();
                ratings.addAll(ratings.stream().filter(s -> s.charAt(finalI) == '0').collect(Collectors.toList()));
                ratings.subList(0, size).clear();
            } else {
                int size = ratings.size();
                ratings.addAll(ratings.stream().filter(s -> s.charAt(finalI) == '1').collect(Collectors.toList()));
                ratings.subList(0, size).clear();
            }
            if (ratings.size() == 1) {
                return Integer.parseInt(ratings.get(0), 2);
            }
        }
        return 0;
    }

    private int calcCo2(List<String> diagnosticReport, List<String> ratings) {
        for (int i = 1; i < diagnosticReport.get(0).length(); i++) {
            int finalI = i;
            if (ratings.stream().filter(reportRow -> reportRow.charAt(finalI) == '0').count() > ratings.stream().filter(reportRow -> reportRow.charAt(finalI) == '1').count()) {
                int size = ratings.size();
                ratings.addAll(ratings.stream().filter(s -> s.charAt(finalI) == '1').collect(Collectors.toList()));
                ratings.subList(0, size).clear();
            } else {
                int size = ratings.size();
                ratings.addAll(ratings.stream().filter(s -> s.charAt(finalI) == '0').collect(Collectors.toList()));
                ratings.subList(0, size).clear();
            }
            if (ratings.size() == 1) {
                return Integer.parseInt(ratings.get(0), 2);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new Day3BinaryDiagnostic();
    }
}
