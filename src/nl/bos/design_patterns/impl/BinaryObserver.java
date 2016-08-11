/**
 * 
 */
package nl.bos.design_patterns.impl;
import static nl.bos.design_patterns.IConstants.STR_EMPTY;
import static nl.bos.design_patterns.IConstants.STR_OUTPUT_CHAT_MESSAGE;

/**
 * @author bosa
 *
 */
public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println(String.format(STR_OUTPUT_CHAT_MESSAGE, this.getClass().getSimpleName(), STR_EMPTY, Integer.toBinaryString(subject.getState())));
	}
}
