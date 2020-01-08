/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_IS_AUTHENTIC;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_PAGE_REQUEST;

/**
 * @author bosa
 *
 */
public class FrontController {
	private Dispatcher dispatcher;

	public FrontController() {
		dispatcher = new Dispatcher();
	}

	private boolean isAuthenticUser() {
		System.out.println(STR_OUTPUT_IS_AUTHENTIC);
		return true;
	}

	private void trackRequest(String request) {
		System.out.println(String.format(STR_OUTPUT_PAGE_REQUEST, request));
	}

	public void dispatchRequest(String request) {
		trackRequest(request);
		if (isAuthenticUser()) {
			dispatcher.dispatch(request);
		}
	}
}
