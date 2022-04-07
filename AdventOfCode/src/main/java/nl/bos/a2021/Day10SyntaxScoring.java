package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.logging.Logger;

public class Day10SyntaxScoring {
    private static final Logger logger = Logger.getLogger(Day10SyntaxScoring.class.getName());

    /**
     * curlyBracket = {}
     * squareBracket = []
     * parenthesis = ()
     * angleBrackets = <>
     */
    public Day10SyntaxScoring() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day10SyntaxScoring");
        List<String> chunksData = AdventReadInput.readData(is);

        List<Character> popChars = List.of('{', '[', '(', '<');
        Deque<Character> chunksStack = new ArrayDeque<>();

        long result = 0L;

        for (String chunks : chunksData) {
            for (int i = 0; i < chunks.length(); i++) {
                char charAt = chunks.charAt(i);
                if (popChars.contains(charAt)) {
                    chunksStack.push(charAt);
                } else if (chunksStack.peek().equals(getApposite(charAt))) {
                    chunksStack.pop();
                } else {
                    result += getPoints(charAt);
                    break;
                }
            }
        }

        String message = MessageFormat.format("Total syntax error score for the errors: {0}", result);
        logger.info(message);
    }

    private long getPoints(char charAt) {
        return switch (charAt) {
            case ')' -> 3L;
            case ']' -> 57L;
            case '}' -> 1197L;
            case '>' -> 25137L;
            default -> throw new IllegalStateException();
        };
    }

    private Character getApposite(char charAt) {
        return switch (charAt) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            case '>' -> '<';
            default -> throw new IllegalStateException();
        };
    }

    public static void main(String[] args) {
        new Day10SyntaxScoring();
    }
}