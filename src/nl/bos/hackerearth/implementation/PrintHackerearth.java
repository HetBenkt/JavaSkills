package nl.bos.hackerearth.implementation;

import java.util.Arrays;
/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/print-hackerearth/
 */
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class PrintHackerearth {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int textLenght = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>
		String text = s.nextLine();
		System.out.println(getTheNumber(textLenght, text));
		s.close();
	}

	private static int getTheNumber(int textLenght, String text) {
		int result = 0;

		char[] letters = text.toCharArray();
		Arrays.sort(letters);

		int countA = 0;
		int countC = 0;
		int countE = 0;
		int countH = 0;
		int countK = 0;
		int countR = 0;
		int countT = 0;
		for (int i = 0; i < letters.length; i++) {
			switch (letters[i]) {
			case 'a':
				countA++;
				break;
			case 'c':
				countC++;
				break;
			case 'e':
				countE++;
				break;
			case 'h':
				countH++;
				break;
			case 'k':
				countK++;
				break;
			case 'r':
				countR++;
				break;
			case 't':
				countT++;
				break;
			default:
				break;
			}
		}

		int[] numbers = { countA, countE, countH, countR };
		Arrays.sort(numbers);
		int lowest = numbers[0] / 2;

		if (countC >= lowest && countK >= lowest && countT >= lowest) {
			result = lowest;
		}

		return result;
	}
}
