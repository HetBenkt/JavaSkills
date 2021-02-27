package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day11SeatingSystem {

    public Day11SeatingSystem() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day11SeatingSystem");
        List<String> data = AdventReadInput.readData(is);

        //TODO

        System.out.print(String.format("Result = %d", 0));
    }

    public static void main(String[] args) {
        new Day11SeatingSystem();
    }
}
