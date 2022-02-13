package nl.bos.a2019;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;

public class Day1TheTyrannyOfTheRocketEquation {

    private long sum = 0;

    public Day1TheTyrannyOfTheRocketEquation() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2019/Day1TheTyrannyOfTheRocketEquation");
        ArrayList<String> data = AdventReadInput.readData(is);

        System.out.println(data.stream().mapToLong(this::convertMass).sum());
    }

    public static void main(String[] args) {
        new Day1TheTyrannyOfTheRocketEquation();
    }

    private long convertMass(String mass) {
        double divide = Double.parseDouble(mass) / 3;
        double floor = Math.floor(divide);
        if (Long.parseLong(mass) <= 5L) {
            long temp = sum;
            sum = 0;
            return temp;
        }
        sum += floor - 2;
        return convertMass(String.valueOf((int) (floor - 2)));
    }
}
