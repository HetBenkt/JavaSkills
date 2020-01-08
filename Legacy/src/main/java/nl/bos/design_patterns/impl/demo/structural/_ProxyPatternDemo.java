/**
 * In proxy pattern, a class represents functionality of another class
 * STRUCTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.structural;

import nl.bos.design_patterns.IImage;
import nl.bos.design_patterns.impl.ProxyImage;

import static nl.bos.design_patterns.IConstants.STR_EMPTY;

/**
 * @author bosa
 *
 */
public class _ProxyPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IImage image = new ProxyImage("image1.jpg");

		image.display();
		System.out.println(STR_EMPTY);

		image.display();
	}
}
