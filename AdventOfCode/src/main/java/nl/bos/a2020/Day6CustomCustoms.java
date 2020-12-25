package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day6CustomCustoms {

    public Day6CustomCustoms() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day6CustomCustoms");
        List<String> data = AdventReadInput.readData(is);

    }

    public static void main(String[] args) {
        new Day6CustomCustoms();
    }
}
