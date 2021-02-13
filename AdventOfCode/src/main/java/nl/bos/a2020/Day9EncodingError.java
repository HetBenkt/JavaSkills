package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day9EncodingError {

    public Day9EncodingError() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day9EncodingError");
        List<String> data = AdventReadInput.readData(is);

        //TODO
    }

    public static void main(String[] args) {
        new Day9EncodingError();
    }
}
