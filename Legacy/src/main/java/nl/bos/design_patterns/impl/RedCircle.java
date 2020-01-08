/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IDrawAPI;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_CIRLE;

/**
 * @author bosa
 *
 */
public class RedCircle implements IDrawAPI {

	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.IDrawAPI#drawCircle(int, int, int)
	 */
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println(String.format(STR_OUTPUT_CIRLE, this.getClass().getSimpleName(), radius, x, y));
	}

}
