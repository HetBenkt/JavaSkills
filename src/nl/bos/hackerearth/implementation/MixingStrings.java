package nl.bos.hackerearth.implementation;

/*
  https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/mixing-strings-1/
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class MixingStrings {

    public static void main(String args[]) throws Exception {
        // Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File("input.txt"));
        int nrTestCases = s.nextInt();
        s.nextLine(); // = Carriage return <Enter>

        ArrayList<String> input = new ArrayList<>();

        for (int i = 0; i < nrTestCases; i++) {
            String text = s.nextLine();
            input.add(text);
        }

        System.out.println(printOutput(input));

        s.close();
    }

    private static int printOutput(ArrayList<String> input) {
        StringBuilder result = new StringBuilder();
        while (input.size() > 0) {
            boolean appendHappend = false;
            String text = input.get(0);
            int end = getIndexEnd(result.toString(), text);
            int begin = getIndexBegin(result.toString(), text);
            if (end != begin || (end != 0 && begin != 0)) {
                if (end > begin) {
                    result.append(text.substring(end));
                    appendHappend = true;
                } else {
                    result.insert(0, text.substring(0, text.length() - begin));
                    appendHappend = true;
                }
            }
            if (end == 0 && begin == 0 && !inOthers(input, text, false) && !inOthers(input, text, true) && getResultInOthers(input, text, false).equals("")) {
                if (!appendHappend) {
                    result.append(text);
                    appendHappend = true;
                }
            }

            if(result.toString().contains(text))
                appendHappend = true;

            if (!appendHappend && !inOthers(input, text, false)) {
                String tempResult = text;
                while(!getResultInOthers(input, tempResult, false).equals(""))
                    tempResult = getResultInOthers(input, tempResult, true);
                result.append(tempResult);
                appendHappend = true;
            }

            input.remove(text);
        }

        return result.length();
    }

    private static String getResultInOthers(ArrayList<String> input, String text, boolean remove) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> tempInput = new ArrayList<>();
        for (String value : input) {
            tempInput.add(value);
        }

        if(tempInput.contains(text))
            tempInput.remove(tempInput.indexOf(text));
        for (String value : tempInput) {
            if(!value.equals(text)) {
                if (value.startsWith(text.substring(text.length() - 1, text.length()))) {
                    if (remove)
                        input.remove(value);
                    return result.append(text).append(value.substring(1, value.length())).toString();
                }
                if (value.endsWith(text.substring(0, 1))) {
                    if (remove)
                        input.remove(value);
                    return result.append(value).append(text.substring(1, text.length())).toString();
                }
            }
        }
        return "";
    }

    private static boolean inOthers(ArrayList<String> input, String text, boolean oneLetter) {
        ArrayList<String> tempInput = new ArrayList<>();
        for (String value : input) {
            tempInput.add(value);
        }

        tempInput.remove(tempInput.indexOf(text));
        for (String value : tempInput) {
            if (!oneLetter) {
                if (value.startsWith(text) || value.endsWith(text))
                    return true;
            } else {
                if (value.contains(text))
                    return true;
            }
        }
        return false;
    }


    private static int getIndexEnd(String result, String text) {
        boolean found = false;
        while (!found) {
            found = result.endsWith(text);
            if(found)
                return text.length();
            text = text.substring(0, text.length() - 1);
            if (text.isEmpty())
                found = true;

        }
        return text.length();
    }

    private static int getIndexBegin(String result, String text) {
        boolean found = false;
        while (!found) {
            found = result.startsWith(text);
            if(found)
                return text.length();
            text = text.substring(1);
            if (text.isEmpty())
                found = true;
        }
        return text.length();
    }
}