/**
 * Composite Entity pattern is used in EJB persistence mechanism. A Composite entity is an EJB entity bean which represents a graph of objects. When a composite entity is updated, internally dependent objects beans get updated automatically as being managed by EJB entity bean.
 * OTHER
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.other;

import nl.bos.design_patterns.impl.Client;

/**
 * @author bosa
 *
 */
public class CompositeEntityPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = new Client();
		client.setData("First Test", "Data1");
		client.printData();
		client.setData("Second Test", "Data2");
		client.printData();
	}
}
