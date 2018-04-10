/**
 * Factory pattern creates an object without exposing the creation logic to the client and refer to a newly created object using a common interface
 * One of the most used design patterns and the best way to create an object
 * CREATIONAL 
 * http://www.tutorialspoint.com/design_pattern/ 
 */
package nl.bos.design_patterns.impl.demo.creational;

import static nl.bos.design_patterns.IConstants.*;
import static nl.bos.design_patterns.IConstants.STR_RECTANGLE;
import static nl.bos.design_patterns.IConstants.STR_SQUARE;
import nl.bos.design_patterns.IShape;
import nl.bos.design_patterns.impl.ShapeFactory;

/**
 * @author bosa
 *
 */
public class FactoryPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		IShape shapeCircle = shapeFactory.getShape(STR_CIRCLE, 0, 0, 0, STR_EMPTY);
		shapeCircle.draw();

		IShape shapeRectangle = shapeFactory.getShape(STR_RECTANGLE, 0, 0, 0, STR_EMPTY);
		shapeRectangle.draw();

		IShape shapeSquare = shapeFactory.getShape(STR_SQUARE, 0, 0, 0, STR_EMPTY);
		shapeSquare.draw();
	}
}
