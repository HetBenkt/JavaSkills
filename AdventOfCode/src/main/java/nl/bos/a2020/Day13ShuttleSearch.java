package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * time     bus7-0  bus13-1 bus59-4 bus31-6 bus19-7 //7,13,x,x,59,x,31,19
 * 1068781    D       .       .       .       .
 * 1068782    .       D       .       .       .
 * 1068783    .       .       .       .       .
 * 1068784    .       .       .       .       .
 * 1068785    .       .       D       .       .
 * 1068786    .       .       .       .       .
 * 1068787    .       .       .       D       .
 * 1068788    D       .       .       .       D
 * <p>
 * time     bus17-0 bus13-2 bus19-3 //17,x,13,19
 * 3417       D       .       .
 * 3418       .       .       .
 * 3419       .       D       .
 * 3420       .       .       D
 * <p>
 * time     bus67-0 bus7-1  bus59-2 bus61-3 //67,7,59,61
 * 754018     D       .       .       .
 * 754019     .       D       .       .
 * 754020     .       .       D       .
 * 754021     .       .       .       D
 * <p>
 * time     bus67-0 bus7-2  bus59-3 bus61-4 //67,x,7,59,61
 * 779210     D       .       .       .
 * 779211     .       .       .       .
 * 779212     .       D       .       .
 * 779213     .       .       D       .
 * 779214     .       .       .       D
 * <p>
 * time     bus67-0 bus7-1  bus59-3 bus61-4 //67,7,x,59,61
 * 1261476    D       .       .       .
 * 1261477    .       D       .       .
 * 1261478    .       .       .       .
 * 1261479    .       .       D       .
 * 1261480    .       .       .       D
 * <p>
 * time        bus1789-0 bus37-1   bus47-2   bus1889-3 //1789,37,47,1889
 * 1202161486    D         .         .         .
 * 1202161487    .         D         .         .
 * 1202161488    .         .         D         .
 * 1202161489    .         .         .         D
 */

//Brute forcing till 200500000000000 isn't worth the time!?
//200000000000000 is too low!!
//500000000000000 is too high!!
//Math over brute force (as always!): https://www.youtube.com/watch?v=ru7mWZJlRQg&ab_channel=RandellHeyman
public class Day13ShuttleSearch {

    public Day13ShuttleSearch(String startTime) {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day13ShuttleSearch");
        List<String> data = AdventReadInput.readData(is);

        String[] inServiceBusIds = data.get(1).split(",");
        Map<Integer, Integer> busIds = new LinkedHashMap<>();
        int offset = 0;
        for (String inServiceBusId : inServiceBusIds) {
            if (!inServiceBusId.equals("x")) {
                busIds.put(Integer.valueOf(inServiceBusId), offset);
            }
            offset++;
        }

        long timestamp = Long.valueOf(startTime);
        boolean run = true;
        while (run) {
            boolean init = false;
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : busIds.entrySet()) {
                int busId = entry.getKey();
                int busOffset = entry.getValue();

                if (busOffset == 0 && (timestamp % busId) == busOffset) {
                    count++;
                    init = true;
                } else if (init && (timestamp % busId) == busId - busOffset) {
                    count++;
                } else {
                    break;
                }
            }
            timestamp++;
            if (count == busIds.size()) {
                run = false;
            }
            if (timestamp % 100_000_000L == 0) {
                System.out.println(String.format("Timestamp = %d", timestamp));
            }
        }

        System.out.println(String.format("Earliest timestamp = %d", timestamp - 1));
    }

    public static void main(String[] args) {
        new Day13ShuttleSearch(args[0]);
    }
}