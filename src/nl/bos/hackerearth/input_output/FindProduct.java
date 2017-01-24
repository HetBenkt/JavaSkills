package nl.bos.hackerearth.input_output;

/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-product/
 */
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * No package structure! Main throws an Exception
 */
public class FindProduct {

	private static final String STR_SEVEN = "7";
	private static final String STR_TEN = "10";
	private static final String STR_TOKEN_DELIM_SPACE = " ";

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		s.nextLine(); // = Carriage return <Enter>
		String numbersWithspace = s.nextLine();
		System.out.println(calcProduct(size, numbersWithspace));
		s.close();
	}

	private static BigInteger calcProduct(int size, String numbersWithspace) {
		BigInteger result = new BigInteger("1");
		StringTokenizer tokenizer = new StringTokenizer(numbersWithspace,
				STR_TOKEN_DELIM_SPACE);
		for (int i = 0; i < size; i++) {
			BigInteger number = new BigInteger(tokenizer.nextToken());
			result = result.multiply(number).mod(
					new BigInteger(STR_TEN).pow(9).add(
							new BigInteger(STR_SEVEN)));
		}
		return result;
	}
}
