/**
 * Bridge pattern is used when we need to decouple an abstraction from its implementation so that the two can vary independently.
 * It involves an interface which acts as a bridge which makes the functionality of concrete classes independent from interface implementer classes
 * STRUCTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.structural;

import nl.bos.design_patterns.impl.Circle;
import nl.bos.design_patterns.impl.GreenCircle;
import nl.bos.design_patterns.impl.RedCircle;
import nl.bos.design_patterns.impl.Shape;

/**
 * @author bosa
 *
 */
public class _BridgePatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape redCircle = new Circle(10, 10, 100, new RedCircle());
		Shape greenCircle = new Circle(20, 20, 200, new GreenCircle());

		redCircle.draw();
		greenCircle.draw();
	}
}
