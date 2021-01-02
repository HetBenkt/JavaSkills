package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//468 too high
public class Day7HandyHaversacks {

    private int counter = 0;

    public Day7HandyHaversacks() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day7HandyHaversacks");
        List<String> data = AdventReadInput.readData(is);

        List<String> bagTypes = new ArrayList<>();
        bagTypes.add("shiny gold");
        while (bagTypes.size() > 0) {
            List<String> resultBagTypes = new ArrayList<>();

            for (String dataLine : data) {
                String[] split = dataLine.split(" bags contain");
                for (String bagType : bagTypes) {
                    if (split[1].contains(bagType)) {
                        counter++;
                        resultBagTypes.add(split[0]);
                    }
                }
            }
            bagTypes.clear();
            bagTypes.addAll(resultBagTypes);
        }

        System.out.println(counter);
    }

    public static void main(String[] args) {
        new Day7HandyHaversacks();
    }
}
