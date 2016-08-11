/**
 * http://www.tutorialspoint.com/java8/java8_default_methods.htm
 */
package nl.bos.java8.default_methods;

import nl.bos.java8.common.IVehicle;

/**
 * @author bosa
 *
 */
public class PlayWithDM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IVehicle vehicle = new Car();
		vehicle.print();
	}
}