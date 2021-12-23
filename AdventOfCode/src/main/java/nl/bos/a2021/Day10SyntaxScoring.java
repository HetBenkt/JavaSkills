package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day10SyntaxScoring {

    public Day10SyntaxScoring() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day10SyntaxScoring");
        List<String> data = AdventReadInput.readData(is);

        //TODO

        System.out.printf("Total syntax error score for the errors: %s", 0);
    }

    public static void main(String[] args) {
        new Day10SyntaxScoring();
    }
}