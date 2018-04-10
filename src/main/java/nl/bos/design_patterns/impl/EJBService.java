/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_PROCESSING;

import nl.bos.design_patterns.IBusinessService;

/**
 * @author bosa
 *
 */
public class EJBService implements IBusinessService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IBusinessService#doProcessing()
	 */
	@Override
	public void doProcessing() {
		System.out.println(String.format(STR_OUTPUT_PROCESSING, this.getClass().getSimpleName()));
	}
}
