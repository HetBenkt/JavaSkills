/**
 * 
 */
package nl.bos.design_patterns.impl;

import nl.bos.design_patterns.IMediaPlayer;

import static nl.bos.design_patterns.IConstants.*;

/**
 * @author bosa
 *
 */
public class AudioPlayer implements IMediaPlayer {

	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		switch (audioType) {
		case STR_MP3:
			System.out.println(String.format(STR_OUTPUT_MEDIA, this.getClass()
					.getSimpleName(), fileName));
			break;
		case STR_VLC:
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
			break;
		case STR_MP4:
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
			break;
		default:
			System.out.println(String.format(STR_OUTPUT_NO_MEDIA, audioType));
			break;
		}
	}
}
