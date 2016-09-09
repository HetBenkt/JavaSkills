/**
 * 
 */
package nl.bos.games.space_invaders;

import static nl.bos.games.space_invaders.ICommons.APP_GROUND_HEIGHT;
import static nl.bos.games.space_invaders.ICommons.APP_HEIGHT;
import static nl.bos.games.space_invaders.ICommons.APP_WIDTH;
import static nl.bos.games.space_invaders.ICommons.PLAYER_IMAGE;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

/**
 * @author x088498
 *
 */
public class Player extends Sprite {
	private final static int OFFSET_X = 6;
	private Board board;

	public Player(Board board) {
		this.board = board;
		ImageIcon ii = new ImageIcon(this.getClass().getResource(PLAYER_IMAGE));

		this.setImage(ii.getImage());
		this.setX(APP_WIDTH / 2 - ii.getImage().getHeight(board) / 2);
		this.setY(APP_HEIGHT - APP_GROUND_HEIGHT - ii.getImage().getHeight(board));
	}

	public void act() {
		this.setX(this.getX() + this.getDx());

		// Make sure not to move outside gameview
		if (this.getX() >= APP_WIDTH - this.getImage().getWidth(board) - OFFSET_X) {
			this.setX(APP_WIDTH - this.getImage().getWidth(board) - OFFSET_X);
		}
		if (this.getX() <= 0) {
			this.setX(0);
		}

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			this.setDx(-2);
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.setDx(2);
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			this.setDx(0);
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.setDx(0);
		}
	}
}
