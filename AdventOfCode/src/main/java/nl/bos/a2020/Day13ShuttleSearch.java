package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * time     bus7-0  bus13-1 bus59-4 bus31-6 bus19-7
 * 1068781    D       .       .       .       .
 * 1068782    .       D       .       .       .
 * 1068783    .       .       .       .       .
 * 1068784    .       .       .       .       .
 * 1068785    .       .       D       .       .
 * 1068786    .       .       .       .       .
 * 1068787    .       .       .       D       .
 * 1068788    D       .       .       .       D
 * <p>
 * time     bus17-0 bus13-2 bus19-3
 * 3417       D       .       .
 * 3418       .       .       .
 * 3419       .       D       .
 * 3420       .       .       D
 * <p>
 * time     bus67-0 bus7-1  bus59-2 bus61-3
 * 754018     D       .       .       .
 * 754019     .       D       .       .
 * 754020     .       .       D       .
 * 754021     .       .       .       D
 * <p>
 * time     bus67-0 bus7-2  bus59-3 bus61-4
 * 779210     D       .       .       .
 * 779211     .       .       .       .
 * 779212     .       D       .       .
 * 779213     .       .       D       .
 * 779214     .       .       .       D
 * <p>
 * time     bus67-0 bus7-1  bus59-3 bus61-4
 * 1261476    D       .       .       .
 * 1261477    .       D       .       .
 * 1261478    .       .       .       .
 * 1261479    .       .       D       .
 * 1261480    .       .       .       D
 * <p>
 * time        bus1789-0 bus37-1   bus47-2   bus1889-3
 * 1202161486    D         .         .         .
 * 1202161487    .         D         .         .
 * 1202161488    .         .         D         .
 * 1202161489    .         .         .         D
 */

//Brute forcing till 100040500000000L isn't worth the time!?
public class Day13ShuttleSearch {

    public Day13ShuttleSearch() {
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

        long timestamp = 100040500000000L;
        boolean run = true;
        while (run) {
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : busIds.entrySet()) {
                int busId = entry.getKey();
                int busOffset = entry.getValue();

                if (busOffset == 0 && (timestamp % busId) == busOffset) {
                    count++;
                } else if ((timestamp % busId) == busId - busOffset) {
                    count++;
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
        new Day13ShuttleSearch();
    }
}