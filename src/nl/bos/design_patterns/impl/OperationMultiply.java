/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IStrategy;

/**
 * @author bosa
 *
 */
public class OperationMultiply implements IStrategy {
	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.IStrategy#doOperation(int, int)
	 */
	@Override
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}

}
