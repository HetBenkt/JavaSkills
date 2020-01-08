/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IState;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_CURRENT_STATE;
/**
 * @author bosa
 *
 */
public class StopState implements IState {

	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.State#doAction(nl.bos.design_patterns.impl.Context)
	 */
	@Override
	public void doAction(Context context) {
		System.out.println(String.format(STR_OUTPUT_CURRENT_STATE, this.getClass().getSimpleName()));
		context.setState(this);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
