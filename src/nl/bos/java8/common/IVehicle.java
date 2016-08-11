/**
 * 
 */
package nl.bos.java8.common;

import static nl.bos.java8.common.IConstants.STR_BLOW_HORN;

/**
 * @author bosa
 *
 */
public interface IVehicle {

	default void print() {
		System.out.println("Vehicle: " + this.getClass().getSimpleName());
	};

	public static void blowHorn() {
		System.out.println(STR_BLOW_HORN);
	};
}
