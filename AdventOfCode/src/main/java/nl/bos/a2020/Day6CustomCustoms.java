package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6CustomCustoms {

    public Day6CustomCustoms() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day6CustomCustoms");
        List<String> data = AdventReadInput.readData(is);

        List<String> groups = new ArrayList<>();
        StringBuilder answers = new StringBuilder();
        for (String line : data) {
            if (!line.isEmpty()) {
                answers.append(line);
            } else {
                groups.add(String.valueOf(answers));
                answers.delete(0, answers.length());
            }
        }
        //The last group...As it has no empty line at the end to detect it!!!!
        groups.add(String.valueOf(answers));

        List<String> normalizedGroups = new ArrayList<>();
        for (String group : groups) {
            String collect = Arrays.asList(group.split(""))
                    .stream()
                    .distinct()
                    .collect(Collectors.joining());
            normalizedGroups.add(collect);
        }

        int sum = normalizedGroups.stream().mapToInt(String::length).sum();

        System.out.println(String.format("Sum is %s", sum));
    }

    public static void main(String[] args) {
        new Day6CustomCustoms();
    }
}
