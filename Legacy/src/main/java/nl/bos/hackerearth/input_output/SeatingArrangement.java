package nl.bos.hackerearth.input_output;

/*
  https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/
 */

import java.io.File;
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class SeatingArrangement {

    private static final int MOD_VALUE = 12;
    private static final String WINDOW_SEAT = " WS";
    private static final String MIDDLE_SEAT = " MS";
    private static final String AISLE_SEAT = " AS";

    public static void main(String args[]) throws Exception {
        //Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(new File("input.txt"));
        int nrTestCases = s.nextInt();
        s.nextLine(); // = Carriage return <Enter>

        for (int i = 0; i < nrTestCases; i++) {
            int seatNr = s.nextInt();
            System.out.println(printFacing(seatNr));
        }
        s.close();
    }

    private static String printFacing(int seatNr) {
        String result = "";
        switch (seatNr % MOD_VALUE) {
            case 1:
                result = seatNr + 11 + WINDOW_SEAT;
                break;
            case 2:
                result = seatNr + 9 + MIDDLE_SEAT;
                break;
            case 3:
                result = seatNr + 7 + AISLE_SEAT;
                break;
            case 4:
                result = seatNr + 5 + AISLE_SEAT;
                break;
            case 5:
                result = seatNr + 3 + MIDDLE_SEAT;
                break;
            case 6:
                result = seatNr + 1 + WINDOW_SEAT;
                break;
            case 7:
                result = seatNr - 1 + WINDOW_SEAT;
                break;
            case 8:
                result = seatNr - 3 + MIDDLE_SEAT;
                break;
            case 9:
                result = seatNr - 5 + AISLE_SEAT;
                break;
            case 10:
                result = seatNr - 7 + AISLE_SEAT;
                break;
            case 11:
                result = seatNr - 9 + MIDDLE_SEAT;
                break;
            case 0:
                result = seatNr - 11 + WINDOW_SEAT;
                break;
            default:
                break;
        }
        return result;
    }
}