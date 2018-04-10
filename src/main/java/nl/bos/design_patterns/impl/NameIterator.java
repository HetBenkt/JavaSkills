/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_NAMES;
import nl.bos.design_patterns.IIterator;

/**
 * @author bosa
 *
 */
public class NameIterator implements IIterator {

	int index;

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IIterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		boolean result = false;

		if (index < STR_NAMES.length)
			result = true;

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IIterator#next()
	 */
	@Override
	public Object next() {
		Object result = null;

		if (this.hasNext())
			result = STR_NAMES[index++];

		return result;
	}
}
