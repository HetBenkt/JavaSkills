/**
 * 
 */
package nl.bos.design_patterns.impl;

import java.util.ArrayList;
import java.util.List;

import nl.bos.design_patterns.IOrder;

/**
 * @author bosa
 *
 */
public class Broker {
	private List<IOrder> orders = new ArrayList<IOrder>();

	public void takeOrder(IOrder order) {
		orders.add(order);
	}

	public void placeOrders() {
		for (IOrder order : orders) {
			order.execute();
		}
		orders.clear();
	}
}