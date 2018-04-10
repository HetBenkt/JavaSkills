/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_CIRCLE;
import static nl.bos.design_patterns.IConstants.STR_RECTANGLE;
import static nl.bos.design_patterns.IConstants.STR_SQUARE;

import java.util.HashMap;

import nl.bos.design_patterns.IColor;
import nl.bos.design_patterns.IShape;

/**
 * @author bosa
 *
 */
public class ShapeFactory extends AbstractFactory {
	private static final HashMap<String, IShape> CIRCLE_MAP = new HashMap<String, IShape>();
	private static final HashMap<String, IShape> RECTANGLE_MAP = new HashMap<String, IShape>();
	private static final HashMap<String, IShape> SQUARE_MAP = new HashMap<String, IShape>();
	
	public IShape getShape(String shapeType, int x, int y, int radius, String color) {
		IShape shape = null;
		
		switch (shapeType) {
		case STR_CIRCLE:
			shape = (IShape)CIRCLE_MAP.get(color);
			if(shape == null) {
				shape = new Circle(x, y, radius, color);
				CIRCLE_MAP.put(color, shape);
			}
			break;
		case STR_RECTANGLE:
			shape = (IShape)RECTANGLE_MAP.get(color);
			if(shape == null) {
				shape = new Rectangle(x, y, radius, color);
				RECTANGLE_MAP.put(color, shape);
			}
			break;
		case STR_SQUARE:
			shape = (IShape)SQUARE_MAP.get(color);
			if(shape == null) {
				shape = new Square(x, y, radius, color);
				SQUARE_MAP.put(color, shape);
			}
			break;
		default:
			break;
		}

		return shape;
	}
	
	@Override
	public IColor getColor(String colorType) {
		return null;
	}
}
