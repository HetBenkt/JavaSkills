package nl.bos.hackerearth.implementation;

/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/psychic-powers/
 */
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class LittleJhoolAndPsychicPowers {

	private static final String STR_GOOD = "Good luck!";
	private static final String STR_BAD = "Sorry, sorry!";

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine();
		System.out.println(hasSixConsecutive0sOr1s(text));
		s.close();
	}

	private static String hasSixConsecutive0sOr1s(String text) {
		char[] numbers = text.toCharArray();
		for (int i = 0; i <= numbers.length-6; i++) {
			if (numbers[i] == numbers[i + 1]
					&& numbers[i + 1] == numbers[i + 2]
					&& numbers[i + 2] == numbers[i + 3]
					&& numbers[i + 3] == numbers[i + 4]
					&& numbers[i + 4] == numbers[i + 5]) {
				return STR_BAD;
			}
		}

		return STR_GOOD;
	}
}