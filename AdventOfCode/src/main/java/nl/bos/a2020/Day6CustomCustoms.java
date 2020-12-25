package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

        System.out.println(String.format("%s", groups.size()));
    }

    public static void main(String[] args) {
        new Day6CustomCustoms();
    }
}
