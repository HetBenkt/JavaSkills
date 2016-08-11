/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.*;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_DRAW;
import nl.bos.design_patterns.IDrawAPI;
import nl.bos.design_patterns.IShape;

/**
 * @author bosa
 *
 */
public class Circle extends Shape implements IShape {

	private int x, y, radius;
	private String color;
	
	public Circle(int x, int y, int radius, IDrawAPI drawAPI) {
		super(drawAPI);
		this.color = STR_EMPTY;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public Circle(int x, int y, int radius, String color) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.radius = radius;
		type = STR_CIRCLE;
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
		if(drawAPI != null)
			drawAPI.drawCircle(radius, x, y);
		if(!color.equals(STR_EMPTY))
			System.out.println(String.format(STR_OUTPUT_SHAPE_DATA, color, x, y, radius));
	}
}
