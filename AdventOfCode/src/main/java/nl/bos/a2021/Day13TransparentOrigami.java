package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day13TransparentOrigami {

    public Day13TransparentOrigami() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day13TransparentOrigami");
        List<String> data = AdventReadInput.readData(is);

        //todo

        System.out.printf("Visible dots after completing just the first fold instruction on your transparent paper: %s", 0);
    }

    public static void main(String[] args) {
        new Day13TransparentOrigami();
    }
}