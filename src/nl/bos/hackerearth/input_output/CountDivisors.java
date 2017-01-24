package nl.bos.hackerearth.input_output;

/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/count-divisors/
 */
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * No package structure! Main throws an Exception
 */
public class CountDivisors {

	private static final String STR_TOKEN_DELIM_SPACE = " ";

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(count(input));
		s.close();
	}

	private static int count(String input) {
		int result = 0;
		double[] data = new double[3];
		StringTokenizer tokenizer = new StringTokenizer(input,
				STR_TOKEN_DELIM_SPACE);
		int index = 0;
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			data[index] = Double.parseDouble(token);
			index++;
		}

		for (double i = data[0]; i <= data[1]; i++) {
			double divisor = i / data[2];
			if ((divisor == Math.floor(divisor)) && !Double.isInfinite(divisor)) {
				result++;
			}
		}
		return result;
	}

}
