/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IItem;
import nl.bos.design_patterns.IPacking;

/**
 * @author bosa
 *
 */
public abstract class ColdDrink implements IItem {
	@Override
	public IPacking packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}
