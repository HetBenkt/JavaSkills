package nl.bos.hackerearth.implementation;

/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/the-great-kian/
 */
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * No package structure! Main throws an Exception
 */
public class TheGreatKian {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int textLenght = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>
		String text = s.nextLine(); // = Carriage return <Enter>
		System.out.println(printOldLegendaryProblem(textLenght, text));
		s.close();
	}

	private static String printOldLegendaryProblem(int textLenght, String text) {
		String result = "";

		long[] integers = new long[textLenght];
		StringTokenizer tokenizer = new StringTokenizer(text, " ");
		int index = 0;
		while (tokenizer.hasMoreTokens()) {
			integers[index] = Long.parseLong(tokenizer.nextToken());
			index++;
		}

		for (int i = 0; i < 3; i++) {
			boolean outOfIndex = false;
			int valueIndex = i;
			long totalValue = 0;
			while (!outOfIndex && valueIndex != textLenght) {
				totalValue += integers[valueIndex];
				valueIndex += 3;
				if (valueIndex >= textLenght) {
					outOfIndex = true;
				}
			}
			result += totalValue + " ";
		}

		return result;
	}
}
