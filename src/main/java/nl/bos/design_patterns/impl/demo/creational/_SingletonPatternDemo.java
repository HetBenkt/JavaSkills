/**
 * Singleton pattern involves a single class which is responsible to create an object while making sure that only single object gets created. 
 * One of the simplest design patterns
 * CREATIONAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.creational;

import nl.bos.design_patterns.impl.SingleObject;

/**
 * @author bosa
 *
 */
public class _SingletonPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// SingleObject singleObject = new SingleObject(); //Not visible
		// constructor
		SingleObject object = SingleObject.getInstance();
		object.showMessage();
	}
}
