/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_BOTTLE;
import nl.bos.design_patterns.IPacking;

/**
 * @author bosa
 *
 */
public class Bottle implements IPacking {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IPacking#pack()
	 */
	@Override
	public String pack() {
		return STR_BOTTLE;
	}

}
