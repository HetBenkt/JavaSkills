/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_BUY;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_SELL;

/**
 * @author bosa
 *
 */
public class Stock {
	private String name;
	private int quantity;

	public Stock(String name, int quality) {
		this.name = name;
		this.quantity = quality;
	}

	public void buy() {
		System.out.println(String.format(STR_OUTPUT_BUY, name, quantity));
	}

	public void sell() {
		System.out.println(String.format(STR_OUTPUT_SELL, name, quantity));
	}
}
