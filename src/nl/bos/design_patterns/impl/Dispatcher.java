/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_STUDENT;
/**
 * @author bosa
 *
 */
public class Dispatcher {
	private StudentView studentView;
	private HomeView homeView;

	public Dispatcher() {
		studentView = new StudentView();
		homeView = new HomeView();
	}

	public void dispatch(String request) {
		if (request.equals(STR_STUDENT)) {
			studentView.show();
		} else {
			homeView.show();
		}
	}
}
