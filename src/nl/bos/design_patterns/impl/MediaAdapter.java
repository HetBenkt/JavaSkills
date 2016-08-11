/**
 * 
 */
package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.STR_MP4;
import static nl.bos.design_patterns.IConstants.STR_VLC;
import nl.bos.design_patterns.IAdvancedMediaPlayer;
import nl.bos.design_patterns.IMediaPlayer;

/**
 * @author bosa
 *
 */
public class MediaAdapter implements IMediaPlayer {

	IAdvancedMediaPlayer advanceMediaPlayer;

	public MediaAdapter(String audioType) {
		switch (audioType) {
		case STR_VLC:
			advanceMediaPlayer = new VlcPlayer();
			break;
		case STR_MP4:
			advanceMediaPlayer = new Mp4Player();
			break;
		default:
			break;
		}
	}

	@Override
	public void play(String audioType, String fileName) {
		switch (audioType) {
		case STR_VLC:
			advanceMediaPlayer.playVlc(fileName);
			break;
		case STR_MP4:
			advanceMediaPlayer.playMp4(fileName);
			break;
		default:
			break;
		}

	}
}
