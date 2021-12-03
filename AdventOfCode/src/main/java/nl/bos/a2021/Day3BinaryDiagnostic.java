package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day3BinaryDiagnostic {

    public Day3BinaryDiagnostic() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day3BinaryDiagnostic");
        List<String> data = AdventReadInput.readData(is);

        //todo

        System.out.println(String.format("Multiply final horizontal position by final depth: %s", data.size()));
    }

    public static void main(String[] args) {
        new Day3BinaryDiagnostic();
    }
}
