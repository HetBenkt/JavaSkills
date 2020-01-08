/**
 * In Null Object pattern, a null object replaces check of NULL object instance. Instead of putting if check for a null value, Null Object reflects a do nothing relationship. Such Null object can also be used to provide default behaviour in case data is not available.
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import nl.bos.design_patterns.impl.AbstractCustomer;
import nl.bos.design_patterns.impl.CustomerFactory;

import static nl.bos.design_patterns.IConstants.STR_NAMES;

/**
 * @author bosa
 *
 */
public class NullObjectPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractCustomer[] customers = new AbstractCustomer[4];
		for (int i = 0; i < customers.length; i++) {
			customers[i] = CustomerFactory.getCustomer(STR_NAMES[i]);
			customers[2] = CustomerFactory.getCustomer("Some other name");
			System.out.println(customers[i].getName());
		}
	}
}