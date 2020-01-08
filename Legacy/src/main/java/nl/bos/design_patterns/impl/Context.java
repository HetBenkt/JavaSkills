/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IState;
import nl.bos.design_patterns.IStrategy;

/**
 * @author bosa
 *
 */
public class Context {
	private IState state;
	private IStrategy strategy;
	
	public Context() {
		//Default constructor
	}
	
	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
	
	public IState getState() {
		return state;
	}

	public void setState(IState state) {
		this.state = state;
	}
}
