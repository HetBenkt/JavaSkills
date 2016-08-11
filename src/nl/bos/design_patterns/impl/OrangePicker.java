/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IFruit;

/**
 * @author bosa
 *
 */
public class OrangePicker extends FruitPicker {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.impl.FruitPicker#makeFruit()
	 */
	@Override
	protected IFruit makeFruit() {
		return new Orange();
	}
}
