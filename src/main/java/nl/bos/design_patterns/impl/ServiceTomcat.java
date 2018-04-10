/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_EXECUTING;
import static nl.bos.design_patterns.IConstants.STR_TOMCAT;

/**
 * @author bosa
 *
 */
public class ServiceTomcat implements IService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.impl.IService#getName()
	 */
	@Override
	public String getName() {
		return STR_TOMCAT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.impl.IService#execute()
	 */
	@Override
	public void execute() {
		System.out.println(String.format(STR_OUTPUT_EXECUTING, this.getClass()
				.getSimpleName()));
	}
}
