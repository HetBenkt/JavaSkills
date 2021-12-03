package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day3BinaryDiagnostic {

    public Day3BinaryDiagnostic() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day3BinaryDiagnostic");
        List<String> diagnosticReport = AdventReadInput.readData(is);

        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();

        int bitRateLength = diagnosticReport.get(0).length();

        for (int i = 0; i < bitRateLength; i++) {
            List<Integer> bitsRates = new ArrayList<>();
            for (String diagnosticRow : diagnosticReport) {
                bitsRates.add(Integer.parseInt(diagnosticRow.substring(i, i + 1)));
            }
            if (bitsRates.stream().filter(integer -> integer == 0).count() > bitsRates.stream().filter(integer -> integer == 1).count()) {
                gammaRate.append("0");
                epsilonRate.append("1");

            } else {
                gammaRate.append("1");
                epsilonRate.append("0");
            }
        }

        System.out.printf("Power consumption of the submarine: %s", Integer.parseInt(String.valueOf(gammaRate), 2) * Integer.parseInt(String.valueOf(epsilonRate), 2));
    }

    public static void main(String[] args) {
        new Day3BinaryDiagnostic();
    }
}
