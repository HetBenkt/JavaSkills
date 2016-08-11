/**
 * Flyweight pattern is primarily used to reduce the number of objects created and to decrease memory footprint and increase performance.
 * STRUCTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.structural;

import static nl.bos.design_patterns.IConstants.STR_COLORS;
import static nl.bos.design_patterns.IConstants.STR_SHAPES;
import nl.bos.design_patterns.impl.Shape;
import nl.bos.design_patterns.impl.ShapeFactory;
/**
 * @author bosa
 *
 */
public class _FlyweightPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			Shape shape= (Shape) new ShapeFactory().getShape(getRandomShape(), getRandomX(), getRandomY(), 100, getRandomColor());
			shape.draw();
		}
	}

	private static String getRandomShape() {
		return STR_SHAPES[(int) (Math.random()*STR_SHAPES.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random()*100);
	}

	private static int getRandomY() {
		return (int) (Math.random()*100);
	}

	private static String getRandomColor() {
		return STR_COLORS[(int) (Math.random()*STR_COLORS.length)];
	}
}
