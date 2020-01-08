/**
 * Adapter pattern works as a bridge between two incompatible interfaces
 * It involves a single class which is responsible to join functionalities of independent or incompatible interfaces
 * STRUCTURAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.structural;

import nl.bos.design_patterns.impl.AudioPlayer;

import static nl.bos.design_patterns.IConstants.*;

/**
 * @author bosa
 *
 */
public class _AdapterPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play(STR_MP3, "Beyond the horizon." + STR_MP3);
		audioPlayer.play(STR_MP4, "Alone." + STR_MP4);
		audioPlayer.play(STR_VLC, "Far Far Away." + STR_VLC);
		audioPlayer.play(STR_AVI, "Mind me." + STR_AVI);
	}
}
