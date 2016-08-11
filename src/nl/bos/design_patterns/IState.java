/**
 * 
 */
package nl.bos.design_patterns;

import nl.bos.design_patterns.impl.Context;

/**
 * @author bosa
 *
 */
public interface IState {
	public void doAction(Context context);
}
