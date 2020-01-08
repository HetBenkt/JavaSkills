/**
 * 
 */
package nl.bos.design_patterns;

import nl.bos.design_patterns.impl.Computer;
import nl.bos.design_patterns.impl.Keyboard;
import nl.bos.design_patterns.impl.Monitor;
import nl.bos.design_patterns.impl.Mouse;

/**
 * @author bosa
 *
 */
public interface IComputerPartVisitor {
	public void visit(Computer computer);

	public void visit(Mouse mouse);

	public void visit(Keyboard keyboard);

	public void visit(Monitor monitor);
}
