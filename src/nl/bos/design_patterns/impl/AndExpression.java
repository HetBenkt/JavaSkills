/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IExpression;

/**
 * @author bosa
 *
 */
public class AndExpression implements IExpression {
	private IExpression expr1, expr2;

	public AndExpression(IExpression expr1, IExpression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.bos.design_patterns.IExpression#interpret(java.lang.String)
	 */
	@Override
	public boolean interpret(String context) {
		return expr1.interpret(context) && expr2.interpret(context);
	}
}
