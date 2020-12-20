package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;

public class Day4PassportProcessing {

    public Day4PassportProcessing() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day4PassportProcessing");
        ArrayList<String> data = AdventReadInput.readData(is);
    }

    public static void main(String[] args) {
        new Day4PassportProcessing();
    }
}
