/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_OUTPUT_MEDIA;
import nl.bos.design_patterns.IAdvancedMediaPlayer;

/**
 * @author bosa
 *
 */
public class VlcPlayer implements IAdvancedMediaPlayer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.bos.design_patterns.IAdvancedMediaPlayer#playVlc(java.lang.String)
	 */
	@Override
	public void playVlc(String fileName) {
		System.out.println(String.format(STR_OUTPUT_MEDIA, this.getClass()
				.getSimpleName(), fileName));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.bos.design_patterns.IAdvancedMediaPlayer#playMp4(java.lang.String)
	 */
	@Override
	public void playMp4(String fileName) {
		// Do nothing.
	}

}
