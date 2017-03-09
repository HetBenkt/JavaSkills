package nl.bos.hackerearth.implementation;

/*
  https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/string-sum/
 */

import java.io.File;
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class StringSum {
	private final static String ALPHABETH = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String args[]) throws Exception {
		// Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new File("input.txt"));

		String text = s.nextLine();
		System.out.println(printSum(text));

		s.close();
	}

	private static int printSum(String text) {
		int result = 0;
		char[] characters = text.toCharArray();
		for (char c : characters) {
			result += ALPHABETH.indexOf(c) + 1;
		}
		return result;
	}
}
