package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day1SonarSweep {

    public Day1SonarSweep() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day1SonarSweep");
        List<String> sonarSweepReport = AdventReadInput.readData(is);

        int result = 0;

        List<Integer> combinesSweepReport = new ArrayList<>();
        for (int j = 0; j < sonarSweepReport.size() - 2; j++) {
            int measure1 = Integer.parseInt(sonarSweepReport.get(j + 0));
            int measure2 = Integer.parseInt(sonarSweepReport.get(j + 1));
            int measure3 = Integer.parseInt(sonarSweepReport.get(j + 2));
            combinesSweepReport.add(measure1 + measure2 + measure3);
        }

        int currentDepthMeasurement = combinesSweepReport.get(0);
        for (int i = 1; i < combinesSweepReport.size(); i++) {
            int nextDepthMeasurement = combinesSweepReport.get(i);
            if (nextDepthMeasurement > currentDepthMeasurement) {
                result++;
            }
            currentDepthMeasurement = nextDepthMeasurement;
        }

        System.out.println(String.format("Measurements are larger than the previous measurement: %s", result));
    }

    public static void main(String[] args) {
        new Day1SonarSweep();
    }
}
