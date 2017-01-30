package nl.bos.hackerearth.input_output;

/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-factorial/
 */
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * No package structure! Main throws an Exception
 */
public class Factorial {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		System.out.println(calcFactorial(number));
		s.close();
	}

	private static BigInteger calcFactorial(int number) {
		BigInteger result = new BigInteger("1");
		for (int i = result.intValue(); i <= number; i++) {
			result = result.multiply(new BigInteger("" + i));
		}
		return result;
	}
}
