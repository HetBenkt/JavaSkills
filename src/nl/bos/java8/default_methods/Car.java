/**
 * 
 */
package nl.bos.java8.default_methods;

import nl.bos.java8.common.IFourWheeler;
import nl.bos.java8.common.IVehicle;

/**
 * @author bosa
 *
 */
public class Car implements IVehicle, IFourWheeler {
	public void print() {
		IVehicle.super.print();
		IFourWheeler.super.print();
		IVehicle.blowHorn();
		System.out.println(this.getClass().getSimpleName());
	}
}
