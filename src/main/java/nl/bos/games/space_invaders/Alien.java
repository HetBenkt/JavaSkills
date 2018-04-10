package nl.bos.games.space_invaders;

import static nl.bos.games.space_invaders.ICommons.ALIEN_IMAGE;

import javax.swing.ImageIcon;

public class Alien extends Sprite {
	public Alien(int x, int y) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(ALIEN_IMAGE));

		this.setImage(ii.getImage());
		this.setX(x);
		this.setY(y);
		this.setDx(1);
	}

	public void act() {
		this.setX(this.getX() + this.getDx());
	}
}
