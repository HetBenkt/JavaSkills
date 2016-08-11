/**
 * Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam; https://www.youtube.com/watch?v=1OpAgZvYXLQ
 */
package nl.bos.java8.lambda_expressions;

import static nl.bos.java8.common.IConstants.STR_ANONYMOUS;
import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_LAMBDA;
import static nl.bos.java8.common.IConstants.STR_OUTPUT_THREAD;
import static nl.bos.java8.common.IConstants.STR_START;

/**
 * @author bosa
 *
 */
public class ThreadSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);				

		//The Anonymous way 
		Thread tAnonymous = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(String.format(STR_OUTPUT_THREAD, STR_ANONYMOUS));
			}
		});
		tAnonymous.start();
		
		//The Lambda way
		Thread tLambda = new Thread(() -> System.out.println(String.format(STR_OUTPUT_THREAD, STR_LAMBDA)));
		tLambda.start();

		System.out.println(STR_END);				
	}

}
