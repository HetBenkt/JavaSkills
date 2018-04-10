package nl.bos.hackerearth.implementation;

/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/final-destination-cakewalk/
 */
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class FinalDestination {

	private final static char UP = 'U';
	private final static char DOWN = 'D';
	private final static char LEFT = 'L';
	private final static char RIGHT = 'R';

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine();
		System.out.println(printFinalDestination(text));
		s.close();
	}

	private static String printFinalDestination(String text) {
		int[] destination = new int[2];
		char[] moves = text.toCharArray();

		for (int i = 0; i < moves.length; i++) {
			switch (moves[i]) {
			case UP:
				destination[1]++;
				break;
			case DOWN:
				destination[1]--;
				break;
			case RIGHT:
				destination[0]++;
				break;
			case LEFT:
				destination[0]--;
				break;

			default:
				break;
			}
		}
		return String.format("%s %s", destination[0], destination[1]);
	}
}