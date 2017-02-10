package nl.bos.hackerearth.input_output;

/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/magical-word/
 */
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception 
 */
public class MagicalWord {
	private static final String STR_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int nrTestCases = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>

		for (int i = 0; i < nrTestCases; i++) {
			int textLenght = s.nextInt();
			s.nextLine(); // = Carriage return <Enter>
			String text = s.nextLine(); // = Carriage return <Enter>
			System.out.println(printMagicalWord(text));
		}
		s.close();
	}

	private static String printMagicalWord(String text) {
		String result = "";
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			result += findNearestMagicalLetter(chars[i]);
		}
		return result;
	}

	private static char findNearestMagicalLetter(char character) {
		boolean primeFound = false;
		char primeLow = character;
		while (!primeFound) {
			primeFound = isPrimeValue(primeLow);
			if (!primeFound)
				primeLow--;
		}

		primeFound = false;
		char primeHigh = character;
		while (!primeFound) {
			primeFound = isPrimeValue(primeHigh);
			if (!primeFound)
				primeHigh++;
		}
		return (char) findClosestChar(character, primeLow, primeHigh);
	}
	
	private static char findClosestChar(char input, char primeLow,
			char primeHigh) {
		if (STR_ALPHABET.contains(("" + primeLow).toLowerCase())
				|| STR_ALPHABET.contains(("" + primeHigh).toLowerCase())) {
			if ((input - primeLow) > (primeHigh - input)) {
				if (STR_ALPHABET.contains(("" + primeHigh).toLowerCase()))
					return primeHigh;
				else
					return primeLow;
			} else {
				if (STR_ALPHABET.contains(("" + primeLow).toLowerCase()))
					return primeLow;
				else
					return primeHigh;
			}
		} else {
			return 67;
		}
	}

	private static boolean isPrimeValue(int value) {
		for (int i = 2; (i * 2) < value; i++) {
			if (value % i == 0)
				return false;
		}
		return true;
	}
}
