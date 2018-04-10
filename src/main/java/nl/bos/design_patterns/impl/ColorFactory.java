/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_B;
import static nl.bos.design_patterns.IConstants.STR_G;
import static nl.bos.design_patterns.IConstants.STR_R;
import nl.bos.design_patterns.IColor;
import nl.bos.design_patterns.IShape;

/**
 * @author bosa
 *
 */
public class ColorFactory extends AbstractFactory {

	@Override
	public IColor getColor(String colorType) {
		IColor color = null;

		switch (colorType) {
		case STR_R:
			color = new Red();
			break;
		case STR_G:
			color = new Green();
			break;
		case STR_B:
			color = new Blue();
			break;
		default:
			break;
		}

		return color;
	}

	@Override
	public IShape getShape(String shapeType, int x, int y, int radius, String color) {
		return null;
	}

}
