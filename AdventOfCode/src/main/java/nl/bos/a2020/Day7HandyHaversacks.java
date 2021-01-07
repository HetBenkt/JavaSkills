package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day7HandyHaversacks {

    public Day7HandyHaversacks() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day7HandyHaversacks");
        List<String> data = AdventReadInput.readData(is);

        List<String> bagTypes = new ArrayList<>();
        Set<String> uniqueBagTypes = new HashSet<>();
        bagTypes.add("shiny gold");
        while (bagTypes.size() > 0) {
            List<String> resultBagTypes = new ArrayList<>();
            for (String dataLine : data) {
                String[] split = dataLine.split(" bags contain");
                for (String bagType : bagTypes) {
                    if (split[1].contains(bagType)) {
                        resultBagTypes.add(split[0]);
                    }
                }
            }
            resultBagTypes.removeAll(uniqueBagTypes);
            uniqueBagTypes.addAll(resultBagTypes);
            bagTypes.clear();
            bagTypes.addAll(resultBagTypes);
        }

        System.out.println(String.format("%d bag colors can eventually contain at least one shiny gold bag!", uniqueBagTypes.size()));
    }

    public static void main(String[] args) {
        new Day7HandyHaversacks();
    }
}
