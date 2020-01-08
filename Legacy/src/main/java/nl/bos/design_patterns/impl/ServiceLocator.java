/**
 * 
 */
package nl.bos.design_patterns.impl;

/**
 * @author bosa
 *
 */
public class ServiceLocator {
	private static Cache cache;

	static {
		cache = new Cache();
	}

	public static IService getService(String jndiName) {
		IService result = null;

		IService service = cache.getService(jndiName);
		if (service != null)
			result = service;
		else {
			InitialContext context = new InitialContext();
			IService newService = (IService) context.lookup(jndiName);
			cache.addService(newService);
			result = newService;
		}

		return result;
	}
}
