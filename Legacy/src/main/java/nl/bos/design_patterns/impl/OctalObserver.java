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
public class OctalObserver extends Observer {

	public OctalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println(String.format(STR_OUTPUT_CHAT_MESSAGE, this.getClass().getSimpleName(), STR_EMPTY, Integer.toOctalString(subject.getState())));
	}
}
