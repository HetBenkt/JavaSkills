/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_IMAGE;

/**
 * @author bosa
 *
 */
public class HomeView {
	public void show() {
		System.out.println(String.format(STR_OUTPUT_IMAGE, this.getClass().getSimpleName()));
	}
}
