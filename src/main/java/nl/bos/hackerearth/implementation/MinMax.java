package nl.bos.hackerearth.implementation;

/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/min-max-3/
 */
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * No package structure! Main throws an Exception
 */
public class MinMax {

	private static final String STR_NO = "NO";
	private static final String STR_YES = "YES";

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int textLenght = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>
		String text = s.nextLine(); // = Carriage return <Enter>
		System.out.println(checkMinMax(textLenght, text));
		s.close();
	}

	private static String checkMinMax(int textLenght, String text) {
		String result = STR_YES;
		int[] numbers = new int[textLenght];
		StringTokenizer tokenizer = new StringTokenizer(text, " ");
		int index = 0;
		while (tokenizer.hasMoreTokens()) {
			numbers[index] = Integer.parseInt(tokenizer.nextToken());
			index++;
		}

		int min = numbers[0];
		int max = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < min)
				min = numbers[i];
			if (numbers[i] > max)
				max = numbers[i];

		}

		for (int i = (min + 1); i < max; i++) {
			if (!text.contains("" + i))
				result = STR_NO;
		}

		return result;
	}
}
