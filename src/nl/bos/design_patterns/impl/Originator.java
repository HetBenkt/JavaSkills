/**
 * 
 */
package nl.bos.design_patterns.impl;

/**
 * @author bosa
 *
 */
public class Originator {
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Memento saveStateToMemento() {
		return new Memento(state);
	}

	public void getStateFromeMemento(Memento memento) {
		state = memento.getState();
	}
}
