package nl.bos.projecteuler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LargeSum {

    public static void main(String[] args) {
        Class largeSum = LargeSum.class;
        String fileName = largeSum.getSimpleName();
        Path path = Paths.get("src//nl//bos//projecteuler//" + fileName + ".in").toAbsolutePath();
        try (Stream<String> stream = Files.lines(path)) {
            String[] lines = stream.toArray(String[]::new);
            double sum = 0;
            for (String line : lines) {
                sum += Double.valueOf(line);
            }
            System.out.println(String.valueOf(sum).substring(0, 11));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
