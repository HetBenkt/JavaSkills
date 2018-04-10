package nl.bos.hackerearth.implementation;

/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/bob-and-bombs-cake-walk/
 */
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class BobAndBombs {
	private final static char WALL = 'W';
	private final static char BOMB = 'B';
	private final static char WALL_EXPLODED = '#';

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int nrTestCases = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>

		for (int i = 0; i < nrTestCases; i++) {
			String text = s.nextLine(); // = Carriage return <Enter>
			System.out.println(printTotalNumberOfDestroyedWall(text));
		}
		s.close();
	}

	private static int printTotalNumberOfDestroyedWall(String text) {
		int result = 0;
		char[] bombsAndWalls = text.toCharArray();
		for (int i = 0; i < bombsAndWalls.length; i++) {
			if (bombsAndWalls[i] == BOMB) {
				if (i - 1 >= 0) {
					if (bombsAndWalls[i - 1] == WALL) {
						bombsAndWalls[i - 1] = WALL_EXPLODED;
						result++;
					}
				}
				if (i - 2 >= 0) {
					if (bombsAndWalls[i - 2] == WALL) {
						bombsAndWalls[i - 2] = WALL_EXPLODED;
						result++;
					}
				}
				if (i + 1 < bombsAndWalls.length) {
					if (bombsAndWalls[i + 1] == WALL) {
						bombsAndWalls[i + 1] = WALL_EXPLODED;
						result++;
					}
				}
				if (i + 2 < bombsAndWalls.length) {
					if (bombsAndWalls[i + 2] == WALL) {
						bombsAndWalls[i + 2] = WALL_EXPLODED;
						result++;
					}
				}
			}
		}

		return result;
	}
}
