/**
 * Basic stopwatch class for keeping track on the execution time
 */
package nl.bos.common;

import static nl.bos.common.IContants.OUTPUT_ELAPSED_TIME;

/**
 * @author bosa
 * 
 */
public class StopWatch {
	private final long init;

	/**
	 * Class constructor
	 */
	public StopWatch() {
		init = System.nanoTime();
	}

	/**
	 * Method for calculating the time elapsed on the stopwatch
	 */
	public void elapsedTime() {
		long now = System.nanoTime();
		long elapsedTime = now - init;
		System.out.println(String.format(OUTPUT_ELAPSED_TIME, (double) (elapsedTime / 1000000000.0)));
	}
}
