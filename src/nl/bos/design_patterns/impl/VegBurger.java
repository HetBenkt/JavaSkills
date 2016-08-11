/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.F_VEG_BURGER_PRICE;
import static nl.bos.design_patterns.IConstants.STR_VEG_BURGER;

/**
 * @author bosa
 *
 */
public class VegBurger extends Burger {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IItem#name()
	 */
	@Override
	public String name() {
		return STR_VEG_BURGER;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.impl.Burger#price()
	 */
	@Override
	public float price() {
		return F_VEG_BURGER_PRICE;
	}

}
