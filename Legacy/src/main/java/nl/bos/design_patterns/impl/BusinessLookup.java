/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IBusinessService;

import static nl.bos.design_patterns.IConstants.STR_EJB;

/**
 * @author bosa
 *
 */
public class BusinessLookup {
	public IBusinessService getBusinessService(String serviceType) {
		IBusinessService result;

		if (serviceType.equalsIgnoreCase(STR_EJB)) {
			result = new EJBService();
		} else {
			result = new JMSService();
		}

		return result;
	}
}