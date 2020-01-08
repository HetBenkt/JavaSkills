/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IBusinessService;

/**
 * @author bosa
 *
 */
public class BusinessDelegate {
	private BusinessLookup lookupService = new BusinessLookup();
	private IBusinessService businessService;
	private String serviceType;

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void doTask() {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.doProcessing();
	}
}