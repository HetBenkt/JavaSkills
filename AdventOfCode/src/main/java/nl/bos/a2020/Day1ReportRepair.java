package nl.bos.a2020;

import nl.bos.general.AdventReadInput;
import org.paukov.combinatorics3.Generator;

import java.io.InputStream;
import java.util.List;

public class Day1ReportRepair {

    public static void main(String[] args) {
        new Day1ReportRepair();
    }

    public Day1ReportRepair() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day1ReportRepair");
        List<String> data = AdventReadInput.readData(is);

        Generator.combination(data).simple(3).stream().forEach(this::sum);
    }

    private void sum(List<String> combination) {
        int sum = 0;
        for (String value : combination) {
            sum += Integer.parseInt(value);
        }
        if (sum == 2020) {
            int value1 = Integer.parseInt(combination.get(0));
            int value2 = Integer.parseInt(combination.get(1));
            int value3 = Integer.parseInt(combination.get(2));
            System.out.println(String.format("%d x %d x %d = %d", value1, value2, value3, value1 * value2 * value3));
            System.exit(0);
        }
    }
}
