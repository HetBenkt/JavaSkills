/**
 * In State pattern a class behavior changes based on its state
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import nl.bos.design_patterns.impl.Context;
import nl.bos.design_patterns.impl.StartState;
import nl.bos.design_patterns.impl.StopState;

/**
 * @author bosa
 *
 */
public class _StatePatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context context = new Context();
		StartState start = new StartState();
		start.doAction(context);
		System.out.println(context.getState().toString());

		StopState stop = new StopState();
		stop.doAction(context);
		System.out.println(context.getState().toString());

	}
}
