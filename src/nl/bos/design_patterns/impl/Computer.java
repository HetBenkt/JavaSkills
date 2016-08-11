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
public class Computer implements IComputerPart {

	IComputerPart[] parts;

	public Computer() {
		parts = new IComputerPart[] { new Mouse(), new Keyboard(),
				new Monitor() };
	}

	@Override
	public void accept(IComputerPartVisitor computerPartVisitor) {
		for (int i = 0; i < parts.length; i++) {
			parts[i].accept(computerPartVisitor);
		}
		computerPartVisitor.visit(this);
	}
}
