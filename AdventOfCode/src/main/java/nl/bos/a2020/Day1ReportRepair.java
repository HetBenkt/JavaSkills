package nl.bos.a2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Day1ReportRepair {

    public Day1ReportRepair() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day1ReportRepair");
        ArrayList<String> data = readData(is);

        for (int i = 0; i < data.size(); i++) {
            int value1 = Integer.parseInt(data.get(i));
            for (int j = i + 1; j < data.size() - i - 1; j++) {
                int value2 = Integer.parseInt(data.get(j));
                if (value1 + value2 == 2020) {
                    System.out.println(String.format("%d x %d = %d", value1, value2, value1 * value2));
                    System.exit(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Day1ReportRepair();
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
