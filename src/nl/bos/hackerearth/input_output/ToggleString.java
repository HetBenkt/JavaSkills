package nl.bos.hackerearth.input_output;

/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/modify-the-string/
 */
import java.util.Scanner;

/**
 * No package structure! 
 * Main throws an Exception
 */
public class ToggleString {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(toggle(input));
		s.close();
	}

	public static String toggle(String input) {
		String result = "";
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			String character = "" + chars[i];
			if (isUpperCase(character)) {
				result += character.toLowerCase();
			} else {
				result += character.toUpperCase();
			}
		}
		return result;
	}

	private static boolean isUpperCase(String character) {
		boolean result = false;
		String alphabeth = "ABCDEFGHIJKLMNOPQRSTUWVXYZ";
		if (alphabeth.contains(character))
			result = true;
		return result;
	}
}
