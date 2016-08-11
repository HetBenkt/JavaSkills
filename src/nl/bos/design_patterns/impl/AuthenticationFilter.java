/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_LOGGER;
import nl.bos.design_patterns.IFilter;

/**
 * @author bosa
 *
 */
public class AuthenticationFilter implements IFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IFilter#execute(java.lang.String)
	 */
	@Override
	public void execute(String request) {
		System.out.println(String.format(STR_OUTPUT_LOGGER, this.getClass()
				.getSimpleName(), request));
	}
}
