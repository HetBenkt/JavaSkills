package nl.bos.a2021;

import nl.bos.general.AdventReadInput;

import java.io.InputStream;
import java.util.List;
import java.util.Stack;

public class Day10SyntaxScoring {

    public Day10SyntaxScoring() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("nl/bos/a2021/Day10SyntaxScoring");
        List<String> chunksData = AdventReadInput.readData(is);

        //curlyBracket = {}
        //squareBracket = []
        //parenthesis = ()
        //angleBrackets = <>
        List<Character> popChars = List.of('{', '[', '(', '<');
        Stack<Character> chunksStack = new Stack<>();

        long result = 0L;

        for (String chunks : chunksData) {
            for (int i = 0; i < chunks.length(); i++) {
                char charAt = chunks.charAt(i);
                if (popChars.contains(charAt)) {
                    chunksStack.push(charAt);
                } else if (chunksStack.peek() == getApposite(charAt)) {
                    chunksStack.pop();
                } else {
                    result += getPoints(charAt);
                    break;
                }
            }
        }

        System.out.printf("Total syntax error score for the errors: %s", result);
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