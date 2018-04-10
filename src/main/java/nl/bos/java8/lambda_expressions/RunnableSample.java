/**
 * Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam; https://www.youtube.com/watch?v=1OpAgZvYXLQ
 */
package nl.bos.java8.lambda_expressions;

import static nl.bos.java8.common.IConstants.STR_ANONYMOUS;
import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_LAMBDA;
import static nl.bos.java8.common.IConstants.STR_OUTPUT_RUN;
import static nl.bos.java8.common.IConstants.STR_START;

/**
 * @author bosa
 *
 */
public class RunnableSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		// The Anonymous way
		Runnable rAnonymous = new Runnable() {
			@Override
			public void run() {
				System.out.println(String.format(STR_OUTPUT_RUN, STR_ANONYMOUS));
			}
		};

		// The Lambda way
		Runnable rLambda = () -> System.out.println(String.format(STR_OUTPUT_RUN, STR_LAMBDA));

		rAnonymous.run();
		rLambda.run();
		System.out.println(STR_END);
	}

}
