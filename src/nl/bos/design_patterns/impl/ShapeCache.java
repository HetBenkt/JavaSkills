/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.CIRCLE_ID;
import static nl.bos.design_patterns.IConstants.RECTANGLE_ID;
import static nl.bos.design_patterns.IConstants.SQUARE_ID;
import static nl.bos.design_patterns.IConstants.STR_EMPTY;

import java.util.Hashtable;

/**
 * @author bosa
 *
 */
public class ShapeCache {
	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();
	
	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}

	public static void loadCache() {
		addShape(new Circle(0, 0, 0, STR_EMPTY), CIRCLE_ID);
		addShape(new Square(0, 0, 0, STR_EMPTY), SQUARE_ID);
		addShape(new Rectangle(0, 0, 0, STR_EMPTY), RECTANGLE_ID);
	}

	private static void addShape(Shape shape, String id) {
		shape.setId(id);
		shapeMap.put(shape.getId(), shape);
	}

}
