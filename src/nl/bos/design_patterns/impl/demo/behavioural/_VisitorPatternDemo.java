/**
 * In Visitor pattern, we use a visitor class which changes the executing algorithm of an element class. By this way, execution algorithm of element can vary as and when visitor varies.
 * BEHAVIORAL
 * http://www.tutorialspoint.com/design_pattern/ 
 */
package nl.bos.design_patterns.impl.demo.behavioural;

import nl.bos.design_patterns.IComputerPart;
import nl.bos.design_patterns.impl.Computer;
import nl.bos.design_patterns.impl.ComputerPartDisplayVisitor;

/**
 * @author bosa
 *
 */
public class _VisitorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}
}
