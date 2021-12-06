package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day5HydrothermalVenture {

    public Day5HydrothermalVenture() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day5HydrothermalVenture");
        List<String> data = AdventReadInput.readData(is);

        //Prepare data
        List<Line> lines = new ArrayList<>();
        for (String row : data) {
            String[] split = row.split(" -> ");
            String[] left = split[0].split(",");
            String[] right = split[1].split(",");
            lines.add(new Line(Integer.parseInt(left[0]),
                    Integer.parseInt(left[1]),
                    Integer.parseInt(right[0]),
                    Integer.parseInt(right[1])
            ));
        }

        System.out.printf("At how many points do at least two lines overlap: %s", 0);
    }


    public static void main(String[] args) {
        new Day5HydrothermalVenture();
    }

    public enum EDirection {
        VERTICAL, HORIZONTAL
    }

    public record Line(int x1, int y1, int x2, int y2, EDirection direction) {
        public Line(int x1, int y1, int x2, int y2) {
            this(x1, y1, x2, y2, (x1 == x2 ? EDirection.VERTICAL : EDirection.HORIZONTAL));
        }
    }
}