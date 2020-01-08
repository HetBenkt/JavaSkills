/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_NAMES;

/**
 * @author bosa
 *
 */
public class CustomerFactory {
	public static AbstractCustomer getCustomer(String name) {
		AbstractCustomer result = new NullCustomer();
		for (int i = 0; i < STR_NAMES.length; i++) {
			if (STR_NAMES[i].equalsIgnoreCase(name))
				result = new RealCustomer(name);
		}
		return result;
	}
}
