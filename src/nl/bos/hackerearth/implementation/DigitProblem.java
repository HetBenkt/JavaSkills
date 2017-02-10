package nl.bos.hackerearth.implementation;

/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/digit-problem/
 */
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * No package structure! Main throws an Exception
 */
public class DigitProblem {

	private static final String STR_SPACE = " ";
	private static final String STR_NINE = "9";

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine();
		System.out.println(findLargestNumber(text));
		s.close();
	}

	private static String findLargestNumber(String text) {
		String result = "";
		StringTokenizer tokenizer = new StringTokenizer(text, STR_SPACE);
		char[] x = tokenizer.nextToken().toCharArray();
		int k = Integer.parseInt(tokenizer.nextToken());
		int nrReplacements = 0;

		for (int i = 0; i < x.length; i++) {
			char number = x[i];
			if (("" + number).equals(STR_NINE) || nrReplacements == k) {
				result += number;
			} else {
				result += STR_NINE;
				nrReplacements++;
			}
		}

		return result;
	}
}