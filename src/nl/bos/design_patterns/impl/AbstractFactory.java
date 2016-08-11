/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IColor;
import nl.bos.design_patterns.IShape;

/**
 * @author bosa
 *
 */
public abstract class AbstractFactory {
	abstract public IColor getColor(String colorType);

	abstract public IShape getShape(String shapeType, int x, int y, int radius, String color);
}
