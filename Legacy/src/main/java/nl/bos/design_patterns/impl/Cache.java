/**
 * 
 */
package nl.bos.design_patterns.impl;

import java.util.ArrayList;
import java.util.List;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_RETURN_CACHED;

/**
 * @author bosa
 *
 */
public class Cache {
	private List<IService> services;

	public Cache() {
		services = new ArrayList<IService>();
	}

	public IService getService(String serviceName) {
		IService result = null;

		for (IService service : services) {
			if (service.getName().equals(serviceName)) {
				System.out.println(String.format(STR_OUTPUT_RETURN_CACHED,
						serviceName));
				result = service;
			}
		}

		return result;
	}

	public void addService(IService newService) {
		boolean exists = false;

		for (IService service : services) {
			if (service.getName().equals(newService.getName())) {
				exists = true;
			}
		}

		if (!exists)
			services.add(newService);
	}
}
