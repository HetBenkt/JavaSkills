/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IShape;

/**
 * @author bosa
 *
 */
public abstract class ShapeDecorator implements IShape {
	protected IShape decoratedShape;
	
	public ShapeDecorator(IShape decoratorShape) {
		this.decoratedShape = decoratorShape;
	}
	
	public void draw() {
		decoratedShape.draw();
	}
}
