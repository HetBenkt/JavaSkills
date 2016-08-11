/**
 * http://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
 * Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam; https://www.youtube.com/watch?v=1OpAgZvYXLQ
 * 
 * Function has 4 things; Lambda has only 2
 * 1. Name
 * 		2. Parameter list //Lambda
 * 		3. Body //Lambda
 * 4. Return type
 */
package nl.bos.java8.lambda_expressions;

import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_OUTPUT_STATE;
import static nl.bos.java8.common.IConstants.STR_START;

import nl.bos.java8.common.IMyFunctionalInterface;
import nl.bos.java8.common.IMyObject;
import nl.bos.java8.common.MyObject;

/**
 * @author bosa
 *
 */
public class PlayWithLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		// The Anonymous way
		IMyFunctionalInterface mfiAnonymous = new IMyFunctionalInterface() {
			@Override
			public void checkState(IMyObject object) {
				System.out.println(String.format(STR_OUTPUT_STATE, object.getStatus().equals("NEW1")));
			}
		};

		// The Lambda way
		IMyFunctionalInterface mfiLambda = (IMyObject object) -> System.out
				.println(String.format(STR_OUTPUT_STATE, object.getStatus().equals("NEW")));

		IMyObject object = new MyObject("NEW");
		mfiAnonymous.checkState(object);
		mfiLambda.checkState(object);

		System.out.println(STR_END);
	}
}