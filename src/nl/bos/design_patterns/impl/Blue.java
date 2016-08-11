/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_FILL;
import nl.bos.design_patterns.IColor;

/**
 * @author bosa
 *
 */
public class Blue implements IColor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IColor#fill()
	 */
	@Override
	public void fill() {
		System.out.println(String.format(STR_OUTPUT_FILL, this.getClass()
				.getSimpleName()));
	}
}
