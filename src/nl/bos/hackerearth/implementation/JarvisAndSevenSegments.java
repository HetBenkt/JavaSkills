package nl.bos.hackerearth.implementation;

/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/jarvis-and-seven-segments-1/
 */
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * No package structure! Main throws an Exception
 */
public class JarvisAndSevenSegments {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int nrTestCases = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>

		for (int i = 0; i < nrTestCases; i++) {
			int textLenght = s.nextInt();
			s.nextLine(); // = Carriage return <Enter>
			String text = s.nextLine(); // = Carriage return <Enter>
			System.out.println(printLowestBulbNumber(text));
		}
		s.close();
	}

	private static String printLowestBulbNumber(String text) {
		String result = "";
		StringTokenizer tokenizer = new StringTokenizer(text, " ");
		int maxValue = 7*7;
		while (tokenizer.hasMoreTokens()) {
			String lowestBulbs = tokenizer.nextToken();
			int bulbs = getTotalNumberOfBulbs(lowestBulbs);
			if (bulbs < maxValue) {
				maxValue = bulbs;
				result = lowestBulbs;
			}
		}
		return result;
	}

	private static int getTotalNumberOfBulbs(String text) {
		int result = 0;
		char[] values = text.toCharArray();
		for(char value : values)
			result += getNumberOfBulbs("" + value);
		return result;
	}

	private static int getNumberOfBulbs(String value) {
		int result = 0;
		switch (value) {
		case "0":
			result = 6;
			break;
		case "1":
			result = 2;
			break;
		case "2":
			result = 5;
			break;
		case "3":
			result = 5;
			break;
		case "4":
			result = 4;
			break;
		case "5":
			result = 5;
			break;
		case "6":
			result = 6;
			break;
		case "7":
			result = 3;
			break;
		case "8":
			result = 7;
			break;
		case "9":
			result = 6;
			break;
		case "A":
			result = 6;
			break;
		case "b":
			result = 5;
			break;
		case "C":
			result = 4;
			break;
		case "d":
			result = 5;
			break;
		case "E":
			result = 5;
			break;
		case "F":
			result = 4;
			break;
		default:
			break;
		}
		return result;
	}
}
