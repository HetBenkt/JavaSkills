/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IFruit;

/**
 * @author bosa
 *
 */
public abstract class FruitPicker {
	protected abstract IFruit makeFruit();
	
	public void pickFruit() {
		IFruit fruit = makeFruit();
		fruit.display();
	}
}
