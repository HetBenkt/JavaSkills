/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IOrder;

/**
 * @author bosa
 *
 */
public class SellStock implements IOrder {

	private Stock abcStock;

	public SellStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IOrder#execute()
	 */
	@Override
	public void execute() {
		abcStock.sell();
	}

}
