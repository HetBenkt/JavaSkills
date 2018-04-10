/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IExpression;

/**
 * @author bosa
 *
 */
public class TerminalExpression implements IExpression {
	private String data;

	public TerminalExpression(String data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IExpression#interpret(java.lang.String)
	 */
	@Override
	public boolean interpret(String context) {
		boolean result = false;

		if (context.contains(data))
			result = true;

		return result;
	}

}
