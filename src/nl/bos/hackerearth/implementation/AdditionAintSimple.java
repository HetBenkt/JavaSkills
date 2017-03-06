package nl.bos.hackerearth.implementation;

/*
  https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/addition-aint-simple/
 */

import java.io.File;
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class AdditionAintSimple {
    private final static String ALPHABETH = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String args[]) throws Exception {
        //Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File("input.txt"));
        int nrTestCases = s.nextInt();
        s.nextLine(); // = Carriage return <Enter>

        for (int i = 0; i < nrTestCases; i++) {
            String text = s.nextLine(); // = Carriage return <Enter>
            System.out.println(printOutput(text));
        }
        s.close();
    }

    private static String printOutput(String text) {
        StringBuilder builder = new StringBuilder();
        int[] values = toIntArray(text);
        for (int i = 0; i < values.length; i++) {
            int value = values[i] + values[values.length - i - 1];
            if (value > ALPHABETH.length())
                value = value - ALPHABETH.length();
            if (value == ALPHABETH.length())
                builder.append(ALPHABETH.substring(value - 1));
            else
                builder.append(ALPHABETH.substring(value - 1, value));
        }
        return builder.toString();
    }

    private static int[] toIntArray(String text) {
        char[] chars = text.toCharArray();
        int[] result = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'a':
                    result[i] = 1;
                    break;
                case 'b':
                    result[i] = 2;
                    break;
                case 'c':
                    result[i] = 3;
                    break;
                case 'd':
                    result[i] = 4;
                    break;
                case 'e':
                    result[i] = 5;
                    break;
                case 'f':
                    result[i] = 6;
                    break;
                case 'g':
                    result[i] = 7;
                    break;
                case 'h':
                    result[i] = 8;
                    break;
                case 'i':
                    result[i] = 9;
                    break;
                case 'j':
                    result[i] = 10;
                    break;
                case 'k':
                    result[i] = 11;
                    break;
                case 'l':
                    result[i] = 12;
                    break;
                case 'm':
                    result[i] = 13;
                    break;
                case 'n':
                    result[i] = 14;
                    break;
                case 'o':
                    result[i] = 15;
                    break;
                case 'p':
                    result[i] = 16;
                    break;
                case 'q':
                    result[i] = 17;
                    break;
                case 'r':
                    result[i] = 18;
                    break;
                case 's':
                    result[i] = 19;
                    break;
                case 't':
                    result[i] = 20;
                    break;
                case 'u':
                    result[i] = 21;
                    break;
                case 'v':
                    result[i] = 22;
                    break;
                case 'w':
                    result[i] = 23;
                    break;
                case 'x':
                    result[i] = 24;
                    break;
                case 'y':
                    result[i] = 25;
                    break;
                case 'z':
                    result[i] = 26;
                    break;
            }
        }

        return result;
    }

}
