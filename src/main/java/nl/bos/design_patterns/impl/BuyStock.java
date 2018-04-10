/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IOrder;

/**
 * @author bosa
 *
 */
public class BuyStock implements IOrder {

	private Stock abcStock;

	public BuyStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IOrder#execute()
	 */
	@Override
	public void execute() {
		abcStock.buy();
	}

}
