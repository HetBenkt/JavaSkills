/**
 * 
 */
package nl.bos.java8.common;

/**
 * @author bosa
 *
 */
public interface IFourWheeler {
	default void print() {
		System.out.println("Four wheeler: " + this.getClass().getSimpleName());
	};
}
