/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_COLOR;
import static nl.bos.design_patterns.IConstants.STR_SHAPE;

/**
 * @author bosa
 *
 */
public class FactoryProducer {
	public static AbstractFactory getFactory(String choise) {
		AbstractFactory abstractFactory = null;

		switch (choise) {
		case STR_SHAPE:
			abstractFactory = new ShapeFactory();
			break;
		case STR_COLOR:
			abstractFactory = new ColorFactory();
			break;
		default:
			break;
		}

		return abstractFactory;
	}
}
