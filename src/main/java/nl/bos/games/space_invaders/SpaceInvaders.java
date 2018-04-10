/**
 * http://zetcode.com/tutorials/javagamestutorial/spaceinvaders/
 */
package nl.bos.games.space_invaders;

import static nl.bos.games.space_invaders.ICommons.APP_HEIGHT;
import static nl.bos.games.space_invaders.ICommons.APP_TITLE;
import static nl.bos.games.space_invaders.ICommons.APP_WIDTH;

import javax.swing.JFrame;

/**
 * @author x088498
 *
 */
public class SpaceInvaders extends JFrame {

	public SpaceInvaders() {
		this.add(new Board());
		this.setTitle(APP_TITLE);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(APP_WIDTH, APP_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SpaceInvaders();
	}
}
