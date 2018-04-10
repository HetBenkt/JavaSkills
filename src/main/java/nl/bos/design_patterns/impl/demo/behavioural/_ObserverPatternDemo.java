/**
 * Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified, its dependent objects are to be notified automatically
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import static nl.bos.design_patterns.IConstants.LEVEL_ERROR;
import static nl.bos.design_patterns.IConstants.LEVEL_FATAL;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_SAVED_STATE;
import nl.bos.design_patterns.impl.BinaryObserver;
import nl.bos.design_patterns.impl.HexaObserver;
import nl.bos.design_patterns.impl.OctalObserver;
import nl.bos.design_patterns.impl.Subject;

/**
 * @author bosa
 *
 */
public class _ObserverPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println(String.format(STR_OUTPUT_SAVED_STATE, LEVEL_FATAL,
				15));
		subject.setState(15);
		System.out.println(String.format(STR_OUTPUT_SAVED_STATE, LEVEL_ERROR,
				10));
		subject.setState(10);
	}
}
