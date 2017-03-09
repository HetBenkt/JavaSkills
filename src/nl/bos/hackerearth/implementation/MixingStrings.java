package nl.bos.hackerearth.implementation;

/*
  https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/mixing-strings-1/
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class MixingStrings {
	private final static int N = 8;
	private final static int LENGHT = 15;

	public static void main(String args[]) throws Exception {
		// Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new File("input.txt"));
		int nrTestCases = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>

		ArrayList<String> input = new ArrayList<String>();

		for (int i = 0; i < nrTestCases; i++) {
			String text = s.nextLine();
			input.add(text);
		}

		System.out.println(printOutput(input));

		s.close();
	}

	private static int printOutput(ArrayList<String> input) {
		char[] characters = new char[N * LENGHT];

		int lastIndex = 0;
		for (String text : input) {
			char[] chars = text.toCharArray();
			int index = 0;
			for (char c : chars) {
				if (characters[index] == '\u0000') {
					characters[index] = c;
					lastIndex++;
				} else {
					if (toString(characters).indexOf(c) == -1) {
						characters[lastIndex] = c;
						lastIndex++;
					}
				}
				index++;

			}
		}
		return lastIndex;
	}

	private static String toString(char[] characters) {
		String result = "";
		for (char c : characters) {
			result += c;
		}
		return result;
	}

}
