/**
 * Lazy initialization is the tactic of delaying the creation of an object, the calculation of a value, or some other expensive process until the first time it is needed.
 * CREATIONAL
 * https://en.wikipedia.org/wiki/Lazy_initialization
 */
package nl.bos.design_patterns.impl.demo.creational;

import nl.bos.design_patterns.impl.Fruit;
import nl.bos.design_patterns.impl.FruitType;

/**
 * @author bosa
 *
 */
public class LazyInitiationPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fruit.getFruitByTypeName(FruitType.banana);
		Fruit.showAll();
		Fruit.getFruitByTypeName(FruitType.apple);
		Fruit.showAll();
		Fruit.getFruitByTypeName(FruitType.banana);
		Fruit.showAll();
	}
}