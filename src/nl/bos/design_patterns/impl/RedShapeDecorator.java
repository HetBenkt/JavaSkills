/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IShape;

/**
 * @author bosa
 *
 */
public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(IShape decoratorShape) {
		super(decoratorShape);
	}
	
	@Override
	public void draw() {
		super.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(IShape decoratedShape) {
		System.out.println("Border Color: Red");
	}
}
