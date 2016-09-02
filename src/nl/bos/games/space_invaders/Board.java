/**
 * 
 */
package nl.bos.games.space_invaders;

import static nl.bos.games.space_invaders.ICommons.APP_GROUND_HEIGHT;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * @author x088498
 *
 */
public class Board extends JPanel implements Runnable, KeyListener {
	private boolean ingame = true;
	private Thread animator;
	private Player player;

	public Board() {
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setBackground(Color.BLACK);

		gameInit();
		this.setDoubleBuffered(true);
	}

	private void gameInit() {

		player = new Player(this);

		if (animator == null || !ingame) {
			animator = new Thread(this);
			animator.start();
		}
	}

	@Override
	public void run() {
		while (ingame) {
			repaint();
		}
		gameOver();
	}

	private void gameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.GREEN);

		if (ingame) {
			g.drawLine(0, this.getHeight() - APP_GROUND_HEIGHT, this.getWidth(), this.getHeight() - APP_GROUND_HEIGHT);
			drawAliens(g);
			drawPlayer(g);
			drawShot(g);
			drawBombing(g);
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	private void drawBombing(Graphics g) {
		// TODO Auto-generated method stub

	}

	private void drawShot(Graphics g) {
		// TODO Auto-generated method stub

	}

	private void drawPlayer(Graphics g) {
		if (player.isVisible())
			g.drawImage(player.getImage(), player.getX(), player.getY(), this);

		if (player.isDying()) {
			player.die();
			ingame = false;
		}

	}

	private void drawAliens(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent ke) {
		System.out.println(String.format("Pressed %s", ke.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		System.out.println(String.format("Released %s", ke.getKeyCode()));
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		System.out.println(String.format("Typed %s", ke.getKeyCode()));
	}
}
