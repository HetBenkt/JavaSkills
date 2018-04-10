/**
 * Memento pattern is used to restore state of an object to a previous state
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_CURRENT_STATE;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_SAVED_STATE;
import static nl.bos.design_patterns.IConstants.STR_STATES;
import nl.bos.design_patterns.impl.CareTaker;
import nl.bos.design_patterns.impl.Originator;

/**
 * @author bosa
 *
 */
public class _MementoPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState(STR_STATES[0]);
		originator.setState(STR_STATES[1]);
		careTaker.add(originator.saveStateToMemento());

		originator.setState(STR_STATES[2]);
		careTaker.add(originator.saveStateToMemento());

		originator.setState(STR_STATES[3]);
		System.out.println(String.format(STR_OUTPUT_CURRENT_STATE,
				originator.getState()));

		originator.getStateFromeMemento(careTaker.get(0));
		System.out.println(String.format(STR_OUTPUT_SAVED_STATE, "First",
				originator.getState()));
		originator.getStateFromeMemento(careTaker.get(1));
		System.out.println(String.format(STR_OUTPUT_SAVED_STATE, "Second",
				originator.getState()));
	}
}
