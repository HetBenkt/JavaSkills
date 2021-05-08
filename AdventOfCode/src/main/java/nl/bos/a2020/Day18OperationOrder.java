package nl.bos.a2020;

import nl.bos.general.AdventReadInput;

import javax.script.ScriptException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day18OperationOrder {

    public Day18OperationOrder() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2020/Day18OperationOrder");
        List<String> expressions = AdventReadInput.readData(is);

        List<Long> resultValues = new ArrayList<>();
        for (String expression : expressions) {
            String rewrite = new Rewriter().rewrite(expression);
            String[] strings = rewrite.split("\n");
            List<String> list = Arrays.asList(strings);
            list.forEach(s -> {
                if (s.startsWith("--")) {
                    s = "-" + calc(s.substring(3));
                }
            });

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
        for (String c : chars) {
            if (c.matches("\\d+")) {
                //TODO
            }

        }
        return totalValue;
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