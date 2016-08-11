/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IComputerPart;
import nl.bos.design_patterns.IComputerPartVisitor;

/**
 * @author bosa
 *
 */
public class Keyboard implements IComputerPart {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IComputerPart#accept(nl.bos.design_patterns.
	 * IComputerPartVisitor)
	 */
	@Override
	public void accept(IComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}
