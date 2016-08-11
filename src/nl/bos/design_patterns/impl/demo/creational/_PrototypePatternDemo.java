/**
 * Prototype pattern refers to creating duplicate object while keeping performance in mind.
 * It's implementing a prototype interface which tells to create a clone of the current object
 * CREATIONAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.creational;

import static nl.bos.design_patterns.IConstants.CIRCLE_ID;
import static nl.bos.design_patterns.IConstants.RECTANGLE_ID;
import static nl.bos.design_patterns.IConstants.SQUARE_ID;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_SHAPE;
import nl.bos.design_patterns.impl.Shape;
import nl.bos.design_patterns.impl.ShapeCache;

/**
 * @author bosa
 *
 */
public class _PrototypePatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeCache.loadCache();

		output(CIRCLE_ID);
		output(SQUARE_ID);
		output(RECTANGLE_ID);
	}

	private static void output(String id) {
		Shape clonedShape = ShapeCache.getShape(id);
		System.out.println(String.format(STR_OUTPUT_SHAPE,
				clonedShape.getType()));

	}
}
