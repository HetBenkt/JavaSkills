package nl.bos.a2020;

import org.paukov.combinatorics3.Generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Day1ReportRepair {

    public Day1ReportRepair() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day1ReportRepair");
        ArrayList<String> data = readData(is);

        Generator.combination(data).simple(3).stream().forEach(this::sum);
    }

    public static void main(String[] args) {
        new Day1ReportRepair();
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

    private ArrayList<String> readData(InputStream is) {
        ArrayList<String> data = new ArrayList<>();

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
