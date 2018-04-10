/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.F_PEPSI_PRICE;
import static nl.bos.design_patterns.IConstants.STR_PEPSI;

/**
 * @author bosa
 *
 */
public class Pepsi extends ColdDrink {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IItem#name()
	 */
	@Override
	public String name() {
		return STR_PEPSI;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.impl.ColdDrink#price()
	 */
	@Override
	public float price() {
		// TODO Auto-generated method stub
		return F_PEPSI_PRICE;
	}

}
