/**
 * In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes.
 * The super-factory that creates other factories -> Factory of factories
 * CREATIONAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.creational;

import nl.bos.design_patterns.IColor;
import nl.bos.design_patterns.IShape;
import nl.bos.design_patterns.impl.AbstractFactory;
import nl.bos.design_patterns.impl.FactoryProducer;

import static nl.bos.design_patterns.IConstants.*;

/**
 * @author bosa
 *
 */
public class _AbstractFactoryPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory(STR_SHAPE);
		IShape shapeCircle = shapeFactory.getShape(STR_CIRCLE, 0, 0, 0, STR_EMPTY);
		shapeCircle.draw();
		IShape shapeRectangle = shapeFactory.getShape(STR_RECTANGLE, 0, 0, 0, STR_EMPTY);
		shapeRectangle.draw();
		IShape shapeSquare = shapeFactory.getShape(STR_SQUARE, 0, 0, 0, STR_EMPTY);
		shapeSquare.draw();

		AbstractFactory colorFactory = FactoryProducer.getFactory(STR_COLOR);
		IColor colorRed = colorFactory.getColor(STR_R);
		colorRed.fill();
		IColor colorGreen = colorFactory.getColor(STR_G);
		colorGreen.fill();
		IColor colorBlue = colorFactory.getColor(STR_B);
		colorBlue.fill();
	}
}
