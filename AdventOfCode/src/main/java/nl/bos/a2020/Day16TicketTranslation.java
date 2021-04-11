package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;

public class Day16TicketTranslation {

    public Day16TicketTranslation() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day16TicketTranslation");
        List<String> data = AdventReadInput.readData(is);

        System.out.printf("Ticket scanning error rate = %d%n", 0);
    }

    public static void main(String[] args) {
        new Day16TicketTranslation();
    }

}