/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IContainer;
import nl.bos.design_patterns.IIterator;

/**
 * @author bosa
 *
 */
public class NameRepository implements IContainer {
	
	
	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.IContainer#getIterator()
	 */
	@Override
	public IIterator getIterator() {
		return new NameIterator();
	}
}
