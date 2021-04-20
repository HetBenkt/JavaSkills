package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day16TicketTranslation {

    public Day16TicketTranslation() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day16TicketTranslation");
        List<String> data = AdventReadInput.readData(is);

        //parse all data
        int rulesIndexEnd = 20;
        List<Rule> rules = new ArrayList<>();
        List<String> nearbyTickets = new ArrayList<>();
        String myTicket = "";
        int index = 0;
        for (String line : data) {
            //rules
            if (index == 0 || index < rulesIndexEnd) {
                String[] ranges = line.substring(line.indexOf(":") + 2).split("or");
                rules.add(new Rule(line.substring(0, line.indexOf(":")), ranges[0].trim(), ranges[1].trim()));
            }
            //my ticket
            if (index == rulesIndexEnd + 2) {
                myTicket = line;
            }
            //nearby tickets
            if (index > rulesIndexEnd + 4) {
                nearbyTickets.add(line);
            }
            index++;
        }

        Set<Integer> numbers = new HashSet<>();
        for (Rule rule : rules) {
            addRangeToNumbers(rule.getRange1(), numbers);
            addRangeToNumbers(rule.getRange2(), numbers);
        }

        List<String> validTickets = new ArrayList<>();
        for (String nearbyTicket : nearbyTickets) {
            String[] values = nearbyTicket.split(",");
            int valueResult = 0;
            for (String value : values) {
                if (!numbers.contains(Integer.parseInt(value))) {
                    valueResult += Integer.parseInt(value);
                }
            }
            if (valueResult == 0) {
                validTickets.add(nearbyTicket);
            }
        }

        //Part 2
        List<String> ruleOrder = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int[] ticketColumn = new int[validTickets.size()];
            int loopIndex = 0;
            for (String validTicket : validTickets) {
                String[] ticketValues = validTicket.split(",");
                ticketColumn[loopIndex] = Integer.parseInt(ticketValues[i]);
                loopIndex++;
            }
            ruleOrder.add(detectRuleType(ticketColumn, rules));
        }

        System.out.printf("Multiplication of the six 'departure'-field values = %d%n", 0);
    }

    private String detectRuleType(int[] ticketColumn, List<Rule> rules) {
        return null;
    }

    private void addRangeToNumbers(String range, Set<Integer> numbers) {
        String[] split = range.split("-");
        for (int i = Integer.parseInt(split[0]); i <= Integer.parseInt(split[1]); i++) {
            numbers.add(i);
        }
    }

    public static void main(String[] args) {
        new Day16TicketTranslation();
    }

    private class Rule {
        private final String type;
        private final String range1;
        private final String range2;

        public Rule(String type, String range1, String range2) {
            this.type = type;
            this.range1 = range1;
            this.range2 = range2;
        }

        public String getType() {
            return type;
        }

        public String getRange1() {
            return range1;
        }

        public String getRange2() {
            return range2;
        }
    }
}