/**
 * Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam; https://www.youtube.com/watch?v=1OpAgZvYXLQ
 */
package nl.bos.java8.lambda_expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static nl.bos.java8.common.IConstants.*;

/**
 * @author bosa
 *
 */
public class ComparatorSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		List<Integer> numbersAnonymous = Arrays.asList(9, 2, 7, 4, 5, 6, 3, 8, 1, 10);
		List<Integer> numbersLambda = Arrays.asList(9, 2, 7, 4, 6, 5, 3, 8, 10, 1);

		// The Anonymous way
		Collections.sort(numbersAnonymous, new Comparator<Integer>() {
			@Override
			public int compare(Integer number1, Integer number2) {
				return number1.compareTo(number2);
			}
		});
		for (Integer numberAnonymous : numbersAnonymous) {
			System.out.println(STR_ANONYMOUS + " - " + numberAnonymous);
		}

		System.out.println("");

		// The Lambda way 1 asc
		Collections.sort(numbersLambda,
				(Integer numberLambda1, Integer numberLambda2) -> numberLambda1.compareTo(numberLambda2));
		for (Integer numberLambda : numbersLambda) {
			System.out.println(STR_LAMBDA + " - " + numberLambda);
		}

		System.out.println("");
		// The Lambda way 2 desc
		Collections.sort(numbersLambda, (numberLambda1, numberLambda2) -> numberLambda2.compareTo(numberLambda1));
		for (Integer numberLambda : numbersLambda) {
			System.out.println(STR_LAMBDA + " - " + numberLambda);
		}

		System.out.println(STR_END);
	}

}
