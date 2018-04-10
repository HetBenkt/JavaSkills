/**
 * Mediator pattern is used to reduce communication complexity between multiple objects or classes. This pattern provides a mediator class which normally handles all the communications between different classes and supports easy maintenance of the code by loose coupling.
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import static nl.bos.design_patterns.IConstants.STR_JOHN;
import static nl.bos.design_patterns.IConstants.STR_ROBERT;
import nl.bos.design_patterns.impl.User;

/**
 * @author bosa
 *
 */
public class _MediatorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User robert = new User(STR_ROBERT);
		User john = new User(STR_JOHN);

		robert.sendMessage("Hi, there!");
		john.sendMessage("Hello, who are you?");
	}
}
