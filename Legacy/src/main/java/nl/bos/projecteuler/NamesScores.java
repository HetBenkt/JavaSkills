package nl.bos.projecteuler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NamesScores {
    public static void main(String[] args) {
        Class namesScores = NamesScores.class;
        String fileName = namesScores.getSimpleName();
        Path path = Paths.get("src//nl//bos//projecteuler//" + fileName + ".in").toAbsolutePath();
        try (Stream<String> stream = Files.lines(path)) {
            String[] lines = stream.toArray(String[]::new);
            System.out.println(lines[0]);
            List<String> names = Arrays.stream(lines[0]
                    .split(","))
                    .sorted()
                    .collect(Collectors.toList());
            int index = 1;
            long totalScore = 0;
            for (String name : names) {
                int worth = calcWorth(name.substring(1, name.length() - 1));
                int nameScore = index * worth;
                totalScore += nameScore;
                index++;
            }
            System.out.println(MessageFormat.format("Result {0}", totalScore));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static int calcWorth(String name) {
        int nameValue = 0;
        char[] chars = name.toCharArray();
        for (char letter : chars) {
            nameValue += (letter - 64);
        }
        return nameValue;
    }
}
