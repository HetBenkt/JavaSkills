package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13ShuttleSearch {

    public Day13ShuttleSearch() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day13ShuttleSearch");
        List<String> data = AdventReadInput.readData(is);

        int timestamp = Integer.parseInt(data.get(0)); //in minutes
        String[] inServiceBusIds = data.get(1).split(",");

        Map<Integer, Integer> closestTimestamps = new HashMap<>();
        for (String inServiceBusId : inServiceBusIds) {
            if (!inServiceBusId.equals("x")) {
                int busId = Integer.parseInt(inServiceBusId);
                int rest = timestamp % busId;
                closestTimestamps.put(busId, (timestamp - rest) + busId);
            }
        }

        int lowestTimestamp = Collections.min(closestTimestamps.values());
        int busId = 0;
        for (Map.Entry<Integer, Integer> entry : closestTimestamps.entrySet()) {
            busId = entry.getKey();
            int value = entry.getValue();
            if (value == lowestTimestamp) {
                break;
            }
        }

        System.out.println(String.format("ID of the earliest bus = %d", (lowestTimestamp - timestamp) * busId));
    }

    public static void main(String[] args) {
        new Day13ShuttleSearch();
    }
}