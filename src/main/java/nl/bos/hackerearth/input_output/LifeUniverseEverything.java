package nl.bos.hackerearth.input_output;

/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/life-the-universe-and-everything/
 */
import java.util.Scanner;

/**
 * No package structure! Main throws an Exception
 */
public class LifeUniverseEverything {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);

		boolean is42 = false;

		while (!is42) {
			int number = s.nextInt();
			s.nextLine(); // = Carriage return <Enter>
			if (number != 42)
				System.out.println(number);
			else
				is42 = true;
		}
		s.close();
	}
}
