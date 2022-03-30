package nl.bos.projecteuler;

import java.text.MessageFormat;

public class NumberLetterCounts {
    private static final String ONE = "one";
    private static final String TWO = "two";
    private static final String THREE = "three";
    private static final String FOUR = "four";
    private static final String FIVE = "five";
    private static final String SIX = "six";
    private static final String SEVEN = "seven";
    private static final String EIGHT = "eight";
    private static final String NINE = "nine";
    private static final String[] ONE_TILL_NINE = {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
    private static final String TEN = "ten";
    private static final String ELEVEN = "eleven";
    private static final String TWELVE = "twelve";
    private static final String TEEN = "teen";
    private static final String THIRTEEN = "thir" + TEEN;
    private static final String FOURTEEN = FOUR + TEEN;
    private static final String FIFTEEN = "fif" + TEEN;
    private static final String SIXTEEN = SIX + TEEN;
    private static final String SEVENTEEN = SEVEN + TEEN;
    private static final String EIGHTEEN = EIGHT + "een";
    private static final String NINETEEN = NINE + TEEN;
    private static final String[] TEN_TILL_NINETEEN = {TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN};
    private static final String TWENTY = "twenty";
    private static final String THIRTY = "thirty";
    private static final String FORTY = "forty";
    private static final String FIFTY = "fifty";
    private static final String SIXTY = SIX + "ty";
    private static final String SEVENTY = SEVEN + "ty";
    private static final String EIGHTY = EIGHT + "y";
    private static final String NINETY = NINE + "ty";
    private static final String[] TENTHS = {TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY};
    private static final String HUNDRED = "hundred";
    private static final String AND = "and";
    private static final String THOUSAND = "thousand";

    public static void main(String[] args) {
        long size = 0;
        //1-9
        for (String number : ONE_TILL_NINE) {
            size += number.length();
        }
        //10-19
        for (String number : TEN_TILL_NINETEEN) {
            size += number.length();
        }
        //20-99
        for (String tenth : TENTHS) {
            size += tenth.length();
            for (String number : ONE_TILL_NINE) {
                size += tenth.length() + number.length();
            }
        }
        //100-999
        for (String hundred : ONE_TILL_NINE) {
            size += hundred.length() + HUNDRED.length();
            for (String number : ONE_TILL_NINE) {
                size += hundred.length() + HUNDRED.length() + AND.length() + number.length();
            }
            for (String number : TEN_TILL_NINETEEN) {
                size += hundred.length() + HUNDRED.length() + AND.length() + number.length();
            }
            for (String tenth : TENTHS) {
                size += hundred.length() + HUNDRED.length() + AND.length() + tenth.length();
                for (String number : ONE_TILL_NINE) {
                    size += hundred.length() + HUNDRED.length() + AND.length() + tenth.length() + number.length();
                }
            }
        }
        //1000
        size += ONE.length() + THOUSAND.length();

        System.out.println(MessageFormat.format("Size {0}", size));
    }
}