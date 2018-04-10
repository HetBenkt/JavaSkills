/**
 * 
 */
package nl.bos.games.space_invaders;

import java.awt.Image;

/**
 * @author x088498
 *
 */
public class Sprite {
	private boolean visible, dying;
	private Image image;
	private int x, y, dx;

	public Sprite() {
		visible = true;
	}

	public void die() {
		visible = false;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isDying() {
		return dying;
	}

	public void setDying(boolean dying) {
		this.dying = dying;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}
}
