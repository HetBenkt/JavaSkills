/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_JBOSS;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_NO_OBJECT;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_SERVICE_AVAILABLE;
import static nl.bos.design_patterns.IConstants.STR_TOMCAT;

/**
 * @author bosa
 *
 */
public class InitialContext {
	public Object lookup(String jndiName) {
		Object result = null;

		switch (jndiName) {
		case STR_TOMCAT:
			System.out.println(String.format(STR_OUTPUT_SERVICE_AVAILABLE,
					jndiName));
			result = new ServiceTomcat();
			break;
		case STR_JBOSS:
			System.out.println(String.format(STR_OUTPUT_SERVICE_AVAILABLE,
					jndiName));
			result = new ServiceJboss();
			break;
		default:
			System.out.println(STR_OUTPUT_NO_OBJECT);
			break;
		}

		return result;
	}
}
