/**
 * The factory pattern is used to replace class constructors, abstracting the process of object generation so that the type of the object instantiated can be determined at run-time.
 * CREATIONAL
 */
package nl.bos.design_patterns.impl.demo.creational;

import nl.bos.design_patterns.impl.ApplePicker;
import nl.bos.design_patterns.impl.FruitPicker;
import nl.bos.design_patterns.impl.OrangePicker;

/**
 * @author bosa
 *
 */
public class _FactoryMethodPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FruitPicker fruitPicker = new OrangePicker();
		fruitPicker.pickFruit();

		fruitPicker = new ApplePicker();
		fruitPicker.pickFruit();
	}
}
