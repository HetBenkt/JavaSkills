/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IItem;

import java.util.ArrayList;
import java.util.List;

import static nl.bos.design_patterns.IConstants.*;

/**
 * @author bosa
 *
 */
public class Meal {
	private List<IItem> items = new ArrayList<IItem>();

	public void addItem(IItem item) {
		items.add(item);
	}

	public float getCosts() {
		float totalCosts = 0.0f;

		for (IItem item : items) {
			totalCosts += item.price();
		}

		return totalCosts;
	}

	public void showItems() {
		for (IItem item : items) {
			System.out.println(String.format(STR_OUTPUT_ITEM, item.name()));
			System.out.println(String.format(STR_OUTPUT_PACKAGING, item
					.packing().pack()));
			System.out.println(String.format(STR_OUTPUT_PRICE, item.price()));
		}
	}
}
