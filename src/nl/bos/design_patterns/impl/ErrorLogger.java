/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_LOGGER;

/**
 * @author bosa
 *
 */
public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		this.level = level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.impl.AbstractLogger#write(java.lang.String)
	 */
	@Override
	protected void write(String message) {
		System.out.println(String.format(STR_OUTPUT_LOGGER, this.getClass()
				.getSimpleName(), message));
	}
}
