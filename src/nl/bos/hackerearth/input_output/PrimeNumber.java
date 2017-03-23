package nl.bos.hackerearth.input_output;

/*
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/count-divisors/
 */
import java.util.Scanner;

public class PrimeNumber {

	private static final String STR_SPACE = " ";

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		StringBuilder builder = new StringBuilder();
		for (int i=2; i<=n; i++) {
			if(isPrime(i)) {
				String append = i + STR_SPACE;
				builder.append(append);
			}
		}

		System.out.print(builder.toString().trim());

		s.close();
	}

	private static boolean isPrime(int n) {
		for(int i=2;i<n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}
