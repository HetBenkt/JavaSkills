package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day4GiantSquid {

    public Day4GiantSquid() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day4GiantSquid");
        List<String> data = AdventReadInput.readData(is);

        //todo

        System.out.printf("Final score be: %s", 0);
    }

    public static void main(String[] args) {
        new Day4GiantSquid();
    }
}
