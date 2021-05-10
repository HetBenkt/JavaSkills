package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import javax.script.ScriptException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day18OperationOrder {

    public Day18OperationOrder() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day18OperationOrder");
        List<String> expressions = AdventReadInput.readData(is);

        List<Long> resultValues = new ArrayList<>();
        for (String expression : expressions) {
            String rewrite = new Rewriter().rewrite(expression);
            String[] strings = rewrite.split("\n");
            List<String> list = Arrays.asList(strings);
            list = list.stream().map(s -> {
                if (s.startsWith("--")) {
                    return "-" + calc(s.substring(3));
                } else
                    return s;
            }).collect(Collectors.toList());

            StringBuilder builder = new StringBuilder();
            List<String> normalizedList = new ArrayList<>();
            boolean startBuilding = false;
            for (String listItem : list) {
                if (startBuilding) {
                    builder.append(listItem.substring(1));
                }
                if (listItem.equals("- ")) {
                    startBuilding = true;
                } else if (listItem.startsWith(" ")) {
                    startBuilding = false;
                }
                if (!startBuilding) {
                    normalizedList.add(listItem);
                }
            }

            long resultValue = calc(expression);
            System.out.printf("resultValue = %d%n", resultValue);
            resultValues.add(resultValue);
        }

        System.out.printf("The sum of the resulting values = %d%n", resultValues.stream().mapToLong(Long::longValue).sum());
    }

    public static void main(String[] args) throws ScriptException {
        new Day18OperationOrder();
    }

    private long calc(String expression) {
        String[] chars = expression.split(" ");
        long totalValue = 0L;
        String expressor = "";
        for (String c : chars) {
            if (c.matches("\\d+")) {
                long thisValue = Long.parseLong(c);
                totalValue = expressor.equals("") ? thisValue : express(totalValue, thisValue, expressor);
            } else if (!c.matches("\\d+")) {
                expressor = c;
            }

        }
        return totalValue;
    }

    private long express(long totalValue, long thisValue, String expressor) {
        switch (expressor) {
            case "+":
                return totalValue + thisValue;
            case "*":
                return totalValue * thisValue;
        }
        return -1;
    }

    private class Rewriter {
        private final StringBuilder output = new StringBuilder();
        private int level = 0;

        public String rewrite(String input) {
            for (char character : input.toCharArray()) {
                switch (character) {
                    case '(':
                        level++;
                        appendNewLine();
                        break;
                    case ')':
                        level--;
                        appendNewLine();
                        break;
                    case ',':
                        appendNewLine();
                        break;
                    default:
                        output.append(character);
                        break;
                }
            }
            return output.toString();
        }

        private void appendNewLine() {
            output.append("\n");
            if (level > 0) {
                for (int i = 0; i < level; i++) {
                    output.append('-');
                }
                output.append(' ');
            }
        }
    }
}