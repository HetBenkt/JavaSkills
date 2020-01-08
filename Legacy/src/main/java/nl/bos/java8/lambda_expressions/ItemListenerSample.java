/**
 * Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam; https://www.youtube.com/watch?v=1OpAgZvYXLQ
 */
package nl.bos.java8.lambda_expressions;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static nl.bos.java8.common.IConstants.*;

/**
 * @author bosa
 *
 */
public class ItemListenerSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		// Init buttons
		JButton btnAnonymous = new JButton();
		JButton btnLambda = new JButton();

		// The Anonymous way
		btnAnonymous.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				System.out.println(String.format(STR_OUTPUT_CHANGE, STR_ANONYMOUS, itemEvent.getID()));

			}
		});

		// The Lambda way
		btnLambda.addItemListener(
				itemEvent -> System.out.println(String.format(STR_OUTPUT_CHANGE, STR_LAMBDA, itemEvent.getID())));

		// Click the buttons
		btnAnonymous.setSelected(true);
		btnLambda.setSelected(true);

		System.out.println(STR_END);
	}

}
