/**
 * Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
 * STRUCTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.structural;

import nl.bos.design_patterns.impl.ShapeMaker;

/**
 * @author bosa
 *
 */
public class _FacadePatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		
		shapeMaker.drawCirle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}
