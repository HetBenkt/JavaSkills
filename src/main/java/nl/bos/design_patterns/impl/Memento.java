/**
 * 
 */
package nl.bos.design_patterns.impl;

/**
 * @author bosa
 *
 */
public class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
