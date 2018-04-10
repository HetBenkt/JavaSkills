package nl.bos.games.space_invaders;

import static nl.bos.games.space_invaders.ICommons.SHOT_IMAGE;

import javax.swing.ImageIcon;

public class Shot extends Sprite {
	private final static int OFFSET_X = 27;
	private final static int OFFSET_Y = 0;

	public Shot(int x, int y) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(SHOT_IMAGE));

		this.setImage(ii.getImage());
		this.setX(x + OFFSET_X);
		this.setY(y + OFFSET_Y);
	}
}
