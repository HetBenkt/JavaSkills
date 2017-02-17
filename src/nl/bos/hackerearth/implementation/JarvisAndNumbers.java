package nl.bos.hackerearth.implementation;

import java.io.File;
/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/jarvis-and-numbers-1/
 */
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 * 
 */

/*
 * 
5
base2 101 = 2
base3 12  = 3
base4 11  = 2
7/3
-> 3

7
base2 111 = 3
base3 21  = 3
base4 13  = 4
base5 12  = 3
base6 11  = 2
15/5 = 3/1
-> 1
 */
public class JarvisAndNumbers {

	public static void main(String args[]) throws Exception {
		//Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new File("input.txt"));
		int nrTestCases = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>

		for (int i = 0; i < nrTestCases; i++) {
			int number = s.nextInt();
			System.out.println(findDenominatorOfAverage(number));
		}
		s.close();
	}

	private static int findDenominatorOfAverage(int number) {
		int totalValue = 0;

		for (int i = 2; i < number; i++) {
			char[] numbers = Integer.toString(number, i).toCharArray();
			int subValue = 0;
			for (int j = 0; j < numbers.length; j++) {
				subValue += Integer.parseInt("0123456789".contains(("" + numbers[j])) ? "" + numbers[j] : translate("" + numbers[j]));

			}
			totalValue += subValue;
		}
		return findLastDevider(totalValue, number - 2);
	}

	private static String translate(String c) {
		String result = "";
		switch (c) {
		case "a":
			result = "10";
			break;
		case "b":
			result = "11";
			break;
		case "c":
			result = "12";
			break;
		case "d":
			result = "13";
			break;
		case "e":
			result = "14";
			break;
		case "f":
			result = "15";
			break;
		case "g":
			result = "16";
			break;
		case "h":
			result = "17";
			break;
		case "i":
			result = "18";
			break;
		case "j":
			result = "19";
			break;
		case "k":
			result = "20";
			break;
		case "l":
			result = "21";
			break;
		case "m":
			result = "22";
			break;
		case "n":
			result = "23";
			break;
		case "o":
			result = "24";
			break;
		case "p":
			result = "25";
			break;
		case "q":
			result = "26";
			break;
		case "r":
			result = "27";
			break;
		case "s":
			result = "28";
			break;
		case "t":
			result = "29";
			break;
		case "u":
			result = "30";
			break;
		case "v":
			result = "31";
			break;
		case "w":
			result = "32";
			break;
		case "x":
			result = "33";
			break;
		case "y":
			result = "34";
			break;
		case "z":
			result = "35";
			break;

		default:
			break;
		}
		return result;
	}

	private static int findLastDevider(int totalValue, int devider) {
		int result = 0;
		boolean isDevidable = true;

		while (isDevidable) {
			if (totalValue % devider == 0 && devider != 1) {
				totalValue = totalValue / devider;
				devider = devider / devider;
			} else {
				result = devider;
				isDevidable = false;
			}
		}
		return result;
	}
}
