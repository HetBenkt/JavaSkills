/**
 * Get a Taste of Lambdas and Get Addicted to Streams by Venkat Subramaniam; https://www.youtube.com/watch?v=1OpAgZvYXLQ
 */
package nl.bos.java8.lambda_expressions;

import static nl.bos.java8.common.IConstants.STR_ANONYMOUS;
import static nl.bos.java8.common.IConstants.STR_END;
import static nl.bos.java8.common.IConstants.STR_LAMBDA;
import static nl.bos.java8.common.IConstants.STR_OUTPUT_CLICK;
import static nl.bos.java8.common.IConstants.STR_START;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author bosa
 *
 */
public class ActionListenerSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		// Init buttons
		JButton btnAnonymous = new JButton();
		JButton btnLambda = new JButton();

		// The Anonymous way
		btnAnonymous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println(String.format(STR_OUTPUT_CLICK, STR_ANONYMOUS, actionEvent.getID()));
			}
		});

		// The Lambda way
		btnLambda.addActionListener(
				actionEvent -> System.out.println(String.format(STR_OUTPUT_CLICK, STR_LAMBDA, actionEvent.getID())));

		//Click the buttons
		btnAnonymous.doClick();
		btnLambda.doClick();
		
		System.out.println(STR_END);
	}

}
