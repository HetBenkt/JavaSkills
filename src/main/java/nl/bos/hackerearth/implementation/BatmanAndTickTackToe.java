package nl.bos.hackerearth.implementation;

/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/batman-and-tick-tack-toe/
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class BatmanAndTickTackToe {

	private final static String STR_YES = "YES";
	private final static String STR_NO = "NO";

	public static void main(String args[]) throws Exception {
		//Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new File("input.txt"));
		int nrTestCases = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>

		for (int i = 0; i < nrTestCases; i++) {
			char[][] tickTackToe = new char[4][4];
			tickTackToe[0] = s.nextLine().toCharArray();
			tickTackToe[1] = s.nextLine().toCharArray();
			tickTackToe[2] = s.nextLine().toCharArray();
			tickTackToe[3] = s.nextLine().toCharArray();

			ArrayList<String> allPossibleMoves = getAllPossibleMoves(tickTackToe);
			System.out.println(couldBatmanHaveWon(allPossibleMoves));
		}
		s.close();
	}

	private static ArrayList<String> getAllPossibleMoves(char[][] tickTackToe) {
		ArrayList<String> result = new ArrayList<String>();

		// All horizontals
		String horizontal = "";
		for (int i = 0; i < tickTackToe.length; i++) {
			for (int j = 0; j < tickTackToe[i].length; j++) {
				horizontal += tickTackToe[i][j];
			}
			result.add(horizontal);
			horizontal = "";
		}

		// All verticals
		String verticals = "";
		for (int i = 0; i < tickTackToe.length; i++) {
			for (int j = 0; j < tickTackToe[i].length; j++) {
				verticals += tickTackToe[j][i];
			}
			result.add(verticals);
			verticals = "";
		}

		// All diagonals
		result.add("" + tickTackToe[0][0] + tickTackToe[1][1]
				+ tickTackToe[2][2] + tickTackToe[3][3]);
		result.add("" + tickTackToe[1][0] + tickTackToe[2][1]
				+ tickTackToe[3][2]);
		result.add("" + tickTackToe[0][1] + tickTackToe[1][2]
				+ tickTackToe[2][3]);
		result.add("" + tickTackToe[0][3] + tickTackToe[1][2]
				+ tickTackToe[2][1] + tickTackToe[3][0]);
		result.add("" + tickTackToe[1][3] + tickTackToe[2][2]
				+ tickTackToe[3][1]);
		result.add("" + tickTackToe[0][2] + tickTackToe[1][1]
				+ tickTackToe[2][0]);

		return result;
	}

	private static String couldBatmanHaveWon(ArrayList<String> allPossibleMoves) {
		for (String possibleMove : allPossibleMoves) {
			char[] moves = possibleMove.toCharArray();
			String[] strMoves = new String[moves.length];
			for (int i = 0; i < moves.length; i++) {
				strMoves[i] = "" + moves[i];
			}
			Arrays.sort(strMoves, Collections.reverseOrder());
			if (strMoves.length == 4) {
				if (strMoves[0].equals("x") && strMoves[1].equals("x")) {
					if ((moves[0] == 'x' && moves[1] == 'x' && moves[2] == '.')
							|| (moves[0] == 'x' && moves[2] == 'x' && moves[1] == '.')
							|| (moves[1] == 'x' && moves[2] == 'x' && (moves[0] == '.' || moves[3] == '.'))
							|| (moves[1] == 'x' && moves[3] == 'x' && moves[2] == '.')
							|| (moves[2] == 'x' && moves[3] == 'x' && moves[1] == '.')) {
						return STR_YES;
					}
				}
			} else if (strMoves.length == 3) {
				if (strMoves[0].equals("x") && strMoves[1].equals("x")) {
					if ((moves[0] == 'x' && moves[1] == 'x' && moves[2] == '.')
							|| (moves[0] == 'x' && moves[2] == 'x' && moves[1] == '.')
							|| (moves[1] == 'x' && moves[2] == 'x' && moves[0] == '.')) {
						return STR_YES;
					}
				}
			}
		}
		return STR_NO;
	}
}