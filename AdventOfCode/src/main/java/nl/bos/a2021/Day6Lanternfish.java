package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6Lanternfish {

    public Day6Lanternfish() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day6Lanternfish");
        List<Integer> lanternFishTimers = Arrays.stream(AdventReadInput.readData(is).get(0).split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        for (int i = 0; i < 80; i++) {
            long newFish = lanternFishTimers.stream().filter(integer -> integer == 0).count();
            lanternFishTimers = lanternFishTimers.stream().map(integer -> {
                if (integer == 0) {
                    integer = 6;
                } else {
                    integer--;
                }
                return integer;
            }).collect(Collectors.toList());
            for (int j = 0; j < newFish; j++) {
                lanternFishTimers.add(8);
            }
        }

        System.out.printf("# lanternfish after 80 days: %s", lanternFishTimers.size());
    }

    public static void main(String[] args) {
        new Day6Lanternfish();
    }
}