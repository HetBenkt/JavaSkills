/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IComputerPartVisitor;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_IMAGE;

/**
 * @author bosa
 *
 */
public class ComputerPartDisplayVisitor implements IComputerPartVisitor {

	@Override
	public void visit(Computer computer) {
		System.out.println(String.format(STR_OUTPUT_IMAGE, computer.getClass()
				.getSimpleName()));
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println(String.format(STR_OUTPUT_IMAGE, mouse.getClass()
				.getSimpleName()));
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println(String.format(STR_OUTPUT_IMAGE, keyboard.getClass()
				.getSimpleName()));
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println(String.format(STR_OUTPUT_IMAGE, monitor.getClass()
				.getSimpleName()));
	}
}
