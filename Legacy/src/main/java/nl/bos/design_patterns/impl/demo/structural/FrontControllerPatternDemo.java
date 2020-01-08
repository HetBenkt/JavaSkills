/**
 *  The front controller design pattern is used to provide a centralized request handling mechanism so that all requests will be handled by a single handler. This handler can do the authentication/ authorization/ logging or tracking of request and then pass the requests to corresponding handlers.
 *  STRUCTURAL
 *  http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.structural;

import nl.bos.design_patterns.impl.FrontController;

import static nl.bos.design_patterns.IConstants.STR_HOME;
import static nl.bos.design_patterns.IConstants.STR_STUDENT;

/**
 * @author bosa
 *
 */
public class FrontControllerPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FrontController frontController = new FrontController();
		frontController.dispatchRequest(STR_HOME);
		frontController.dispatchRequest(STR_STUDENT);
	}
}
