package nl.bos.hackerearth.input_output;

/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/palindrome-check-2/
 */
import java.util.Scanner;

/**
 * No package structure! 
 * Main throws an Exception
 */
public class PalindromicString {

	private static final String STR_NO = "NO";
	private static final String STR_YES = "YES";

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(isPalindrome(input));
		s.close();
	}

	public static String isPalindrome(String input) {
		boolean result = false;
		char[] chars = input.toCharArray();
		int halfSize = (int) Math.ceil((double) chars.length / 2);

		for (int i = 0; i < halfSize; i++) {
			if (chars[i] == chars[(chars.length - 1) - i])
				result = true;
			else {
				result = false;
				break;
			}
		}

		return result ? STR_YES : STR_NO;
	}
}
