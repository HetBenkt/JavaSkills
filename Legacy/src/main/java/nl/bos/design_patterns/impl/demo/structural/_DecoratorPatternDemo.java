/**
 * Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
 * STRUCTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.structural;

import nl.bos.design_patterns.IShape;
import nl.bos.design_patterns.impl.Circle;
import nl.bos.design_patterns.impl.Rectangle;
import nl.bos.design_patterns.impl.RedShapeDecorator;

import static nl.bos.design_patterns.IConstants.STR_EMPTY;

/**
 * @author bosa
 *
 */
public class _DecoratorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IShape circle = new Circle(0, 0, 0, STR_EMPTY);
		IShape redCircle = new RedShapeDecorator(new Circle(0, 0, 0, STR_EMPTY));
		
		IShape redRectangle = new RedShapeDecorator(new Rectangle(0, 0, 0, STR_EMPTY));
		
		circle.draw();
		System.out.println(STR_EMPTY);
		redCircle.draw();
		System.out.println(STR_EMPTY);
		redRectangle.draw();
	}
}
