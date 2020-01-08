/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.F_COKE_PRICE;
import static nl.bos.design_patterns.IConstants.STR_COKE;

/**
 * @author bosa
 *
 */
public class Coke extends ColdDrink {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IItem#name()
	 */
	@Override
	public String name() {
		return STR_COKE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.impl.ColdDrink#price()
	 */
	@Override
	public float price() {
		// TODO Auto-generated method stub
		return F_COKE_PRICE;
	}

}
