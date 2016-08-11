package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IItem;
import nl.bos.design_patterns.IPacking;

/**
 * @author bosa
 *
 */
public abstract class Burger implements IItem {
	@Override
	public IPacking packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();

}
