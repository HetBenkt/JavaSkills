package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day7HandyHaversacks {

    public Day7HandyHaversacks() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day7HandyHaversacks");
        List<String> data = AdventReadInput.readData(is);

        /*
        1 shiny gold -> 1 dark olive (3 faded blue + 4 dotted black) + 2 vibrant plum (5 faded blue + 6 dotted black)
				        1 + 		 (1*3 		   + 1*4) 			 + 2 +			  (2*5 		    + 2*6) ) 			= 32
        1 shiny gold -> 2 dark red 	 (2 dark orange (2 dark yellow (2 dark green (2 dark blue (2 dark violet) ) ) ) )
				        2 +			 (2*2		   +(4*2		  +(8*2			+(16*2		 +(32*2) 		  ) ) ) )	= 126!!
        1 shiny gold -> 3 wavy gold                     + 2 plaid chartreuse + 2 shiny line     + 5 dull indigo
				        3 +	(3*5 + 3*1 +3*4 + 3*1)	    + 2	 + (2*1 + 2*5)	 + 2 + (2*1 + 2*1)    + 5 + (5*3 + 5*4 + 5*3 + 5*1)                  = 12!!

         */

        List<String> bags = new ArrayList<>();
        bags.add("1 shiny gold");
        int total = 0;
        while (!bags.isEmpty()) {
            bags = getWhatsInTheBag(data, bags);
            total += bags.stream().map(s -> {
                if (!s.equals("no other")) {
                    return Integer.parseInt(s.substring(0, s.indexOf(' ')));
                }
                return 0;
            }).reduce(0, Integer::sum);
        }
        System.out.println(String.format("%d individual bags are required inside the single shiny gold bag!", total));
    }

    private List<String> getWhatsInTheBag(List<String> data, List<String> bags) {
        List<String> result = new ArrayList<>();
        for (String dataLine : data) {
            for (String bag : bags) {
                if (dataLine.startsWith(bag.substring(bag.indexOf(' ') + 1))) {
                    result.addAll(getBagTypes(dataLine, Integer.parseInt(bag.substring(0, bag.indexOf(' ')))));
                }
            }
        }
        return result;
    }

    private List<String> getBagTypes(String dataLine, int multiplier) {
        String bagTypes = dataLine.substring(dataLine.indexOf("contain") + 8);
        return Arrays.stream(bagTypes.split(",")).map(s -> trim(s, multiplier)).collect(Collectors.toList());
    }

    private String trim(String s, int multiplier) {
        String line = s.substring(0, s.indexOf("bag")).trim();
        int value;
        try {
            value = Integer.parseInt(line.substring(0, line.indexOf(' '))) * multiplier;
        } catch (NumberFormatException nfe) {
            return line;
        }
        line = value + " " + line.substring(2);
        return line;
    }

    public static void main(String[] args) {
        new Day7HandyHaversacks();
    }
}
