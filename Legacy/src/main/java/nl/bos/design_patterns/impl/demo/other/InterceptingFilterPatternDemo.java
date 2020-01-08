/**
 * The intercepting filter design pattern is used when we want to do some pre-processing / post-processing with request or response of the application. Filters are defined and applied on the request before passing the request to actual target application. Filters can do the authentication/ authorization/ logging or tracking of request and then pass the requests to corresponding handlers.
 * STRUCTURAL
 * http://www.tutorialspoint.com/design_pattern/ 
 */
package nl.bos.design_patterns.impl.demo.other;

import nl.bos.design_patterns.impl.*;

import static nl.bos.design_patterns.IConstants.STR_HOME;

/**
 * @author bosa
 *
 */
public class InterceptingFilterPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FilterManager filterManager = new FilterManager(new Target());
		filterManager.setFilter(new AuthenticationFilter());
		filterManager.setFilter(new DebugFilter());

		Client client = new Client();
		client.setFilterManager(filterManager);
		client.sendRequest(STR_HOME);
	}
}
