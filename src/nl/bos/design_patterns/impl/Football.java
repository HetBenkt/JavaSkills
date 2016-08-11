/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.*;
/**
 * @author bosa
 *
 */
public class Football extends Game {

	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.impl.Game#initialize()
	 */
	@Override
	void initialize() {
		System.out.println(String.format(STR_GAME_INIT, this.getClass().getSimpleName()));
	}

	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.impl.Game#startPlay()
	 */
	@Override
	void startPlay() {
		System.out.println(String.format(STR_GAME_START, this.getClass().getSimpleName()));
	}

	/* (non-Javadoc)
	 * @see nl.bos.design_patterns.impl.Game#endPlay()
	 */
	@Override
	void endPlay() {
		System.out.println(String.format(STR_GAME_FINISH, this.getClass().getSimpleName()));
	}

}
