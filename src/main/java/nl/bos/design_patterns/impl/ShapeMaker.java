/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_EMPTY;
import nl.bos.design_patterns.IShape;

/**
 * @author bosa
 *
 */
public class ShapeMaker {
	private IShape circle;
	private IShape rectangle;
	private IShape square;
	
	public ShapeMaker() {
		circle = new Circle(0, 0, 0, STR_EMPTY);
		rectangle = new Rectangle(0, 0, 0, STR_EMPTY);
		square = new Square(0, 0, 0, STR_EMPTY);
	}
	
	public void drawCirle() {
		circle.draw();
	}
	
	public void drawRectangle() {
		rectangle.draw();
	}
	
	public void drawSquare() {
		square.draw();
	}
}