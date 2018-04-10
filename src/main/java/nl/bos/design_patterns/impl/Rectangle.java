/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_EMPTY;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_DRAW;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_SHAPE_DATA;
import static nl.bos.design_patterns.IConstants.STR_RECTANGLE;
import nl.bos.design_patterns.IShape;

/**
 * @author bosa
 *
 */
public class Rectangle extends Shape implements IShape {
	private int x, y, radius;
	private String color;
	
	public Rectangle(int x, int y, int radius, String color) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.radius = radius;
		type = STR_RECTANGLE;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IShape#draw()
	 */
	@Override
	public void draw() {
		System.out.println(String.format(STR_OUTPUT_DRAW, this.getClass()
				.getSimpleName()));
		if(!color.equals(STR_EMPTY))
			System.out.println(String.format(STR_OUTPUT_SHAPE_DATA, color, x, y, radius));
	}
}
