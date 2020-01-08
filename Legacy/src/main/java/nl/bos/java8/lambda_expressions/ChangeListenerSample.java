/**
 * Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam; https://www.youtube.com/watch?v=1OpAgZvYXLQ
 */
package nl.bos.java8.lambda_expressions;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static nl.bos.java8.common.IConstants.*;

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
