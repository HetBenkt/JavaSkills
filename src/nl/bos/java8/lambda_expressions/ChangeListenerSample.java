/**
 * Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam; https://www.youtube.com/watch?v=1OpAgZvYXLQ
 */
package nl.bos.java8.lambda_expressions;

import static nl.bos.java8.common.IConstants.STR_ANONYMOUS;
import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_LAMBDA;
import static nl.bos.java8.common.IConstants.STR_OUTPUT_CHANGE;
import static nl.bos.java8.common.IConstants.STR_START;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author bosa
 *
 */
public class ChangeListenerSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		// Init buttons
		JSlider sldAnonymous = new JSlider();
		JSlider sldLambda = new JSlider();

		// The Anonymous way
		sldAnonymous.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent changeEvent) {
				System.out.println(String.format(STR_OUTPUT_CHANGE, STR_ANONYMOUS, changeEvent.getSource().toString()));
			}
		});

		// The Lambda way
		sldLambda.addChangeListener(changeEvent -> System.out
				.println(String.format(STR_OUTPUT_CHANGE, STR_LAMBDA, changeEvent.getSource().toString())));

		// Click the buttons
		sldAnonymous.setValue(0);
		sldLambda.setValue(0);

		System.out.println(STR_END);
	}

}
