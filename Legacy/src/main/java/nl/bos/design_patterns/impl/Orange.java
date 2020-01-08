/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IFruit;

/**
 * @author bosa
 *
 */
public class Orange implements IFruit {

	@Override
	public void display() {
		System.out.println(this.getClass().getSimpleName());
	}
}
