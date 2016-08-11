/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_NOT_AVAILABLE;

/**
 * @author bosa
 *
 */
public class NullCustomer extends AbstractCustomer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.impl.AbstractCustomer#isNil()
	 */
	@Override
	public boolean isNil() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.impl.AbstractCustomer#getName()
	 */
	@Override
	public String getName() {
		return STR_OUTPUT_NOT_AVAILABLE;
	}
}
