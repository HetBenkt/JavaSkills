/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IColor;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_FILL;

/**
 * @author bosa
 *
 */
public class Red implements IColor {

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
