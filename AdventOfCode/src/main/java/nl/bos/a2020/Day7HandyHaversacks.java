package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day7HandyHaversacks {

    public Day7HandyHaversacks() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day7HandyHaversacks");
        List<String> data = AdventReadInput.readData(is);

        /*
        1 shiny gold -> 1 dark olive (3 faded blue + 4 dotted black) + 2 vibrant plum (5 faded blue + 6 dotted black)
				        1 + 		 (1*3 		   + 1*4) 			 + 2 +			  (2*5 		    + 2*6) ) 			= 32
        1 shine gold -> 2 dark red 	 (2 dark orange (2 dark yellow (2 dark green (2 dark blue (2 dark violet) ) ) ) )
				        2 +			 (2*2		   +(4*2		  +(8*2			+(16*2		 +(32*2) 		  ) ) ) )	= 126!!
         */

        Set<String> uniqueBagTypes = new HashSet<>();
        //TODO

        System.out.println(String.format("%d individual bags are required inside the single shiny gold bag!", uniqueBagTypes.size()));
    }

    public static void main(String[] args) {
        new Day7HandyHaversacks();
    }
}
