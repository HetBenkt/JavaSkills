package nl.bos.hackerearth.implementation;

/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/print-hackerearth/
 */
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class PrintHackerearth {

	private static final char[] HACKEREARTH = { 'h', 'a', 'c', 'k', 'e', 'r', 'e', 'a', 'r', 't', 'h' };
	private static final String STR_HACKEREARTH = "hackerearth";
	private static final char HASHTAG = '#';

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
		boolean letterFound = false;
		while (hasLettersOver(letters)) {
			String checkText = "";
			for (int i = 0; i < HACKEREARTH.length; i++) {
				letterFound = false;
				for (int j = 0; j < letters.length; j++) {
					if (HACKEREARTH[i] == letters[j]) {
						checkText += letters[j];
						letters[j] = HASHTAG;
						letterFound = true;
						break;
					}
				}
				if (!letterFound)
					break;
			}
			if (checkText.equals(STR_HACKEREARTH))
				result++;
			else
				break;
		}
		return result;
	}

	private static boolean hasLettersOver(char[] letters) {
		boolean result = true;

		if (letters.length < HACKEREARTH.length) {
			result = false;
		}

		if (result) {
			int hashTagCounter = 0;
			for (int i = 0; i < letters.length; i++) {
				if (letters[i] == HASHTAG) {
					hashTagCounter++;
				}
			}
			if ((letters.length - hashTagCounter) < HACKEREARTH.length)
				result = false;
		}

		return result;
	}
}
