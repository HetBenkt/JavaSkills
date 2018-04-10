/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_LOGGER;

/**
 * @author bosa
 *
 */
public class Target {
	public void execute(String request) {
		System.out.println(String.format(STR_OUTPUT_LOGGER, this.getClass().getSimpleName(), request));
	}
}
