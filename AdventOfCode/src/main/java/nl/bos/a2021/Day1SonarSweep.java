package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;

public class Day1SonarSweep {

    public Day1SonarSweep() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day1SonarSweep");
        ArrayList<String> sonarSweepReport = AdventReadInput.readData(is);

        int result = 0;
        int currentDepthMeasurement = Integer.parseInt(sonarSweepReport.get(0));
        for (int i = 1; i < sonarSweepReport.size(); i++) {
            int nextDepthMeasurement = Integer.parseInt(sonarSweepReport.get(i));
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
