/**
 * The service locator design pattern is used when we want to locate various services using JNDI lookup. Considering high cost of looking up JNDI for a service, Service Locator pattern makes use of caching technique. For the first time a service is required, Service Locator looks up in JNDI and caches the service object. Further lookup or same service via Service Locator is done in its cache which improves the performance of application to great extent.
 * ARCHITECTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.architectural;

import nl.bos.design_patterns.impl.IService;
import nl.bos.design_patterns.impl.ServiceLocator;

import static nl.bos.design_patterns.IConstants.STR_JBOSS;
import static nl.bos.design_patterns.IConstants.STR_TOMCAT;

/**
 * @author bosa
 *
 */
public class ServiceLocatorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IService service = ServiceLocator.getService(STR_TOMCAT);
		service.execute();
		service = ServiceLocator.getService(STR_JBOSS);
		service.execute();
		service = ServiceLocator.getService(STR_TOMCAT);
		service.execute();
		service = ServiceLocator.getService(STR_JBOSS);
		service.execute();
	}
}
