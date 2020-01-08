/**
 * 
 */
package nl.bos.games.space_invaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import static nl.bos.games.space_invaders.ICommons.*;

/**
 * @author x088498
 *
 */
public class Board extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	private boolean ingame = true;
	private Thread animator;
	private Player player;
	private Shot shot;
	private int alienDirection = 1;
	private ArrayList<Alien> aliens;

	public Board() {
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setBackground(Color.BLACK);

		gameInit();
		this.setDoubleBuffered(true);
	}

	private void gameInit() {
		player = new Player(this);
		aliens = new ArrayList<Alien>();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				Alien alien = new Alien(10 + 80*i, 10 + 70*j);
				aliens.add(alien);
			}
		}
		if (animator == null || !ingame) {
			animator = new Thread(this);
			animator.start();
		}
	}

	@Override
	public void run() {
		long timeDiff, sleep;
		long beforeTime = System.currentTimeMillis();

		while (ingame) {
			repaint();
			animationCycle();

			// Add delay in game refreshment
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = APP_DELAY - timeDiff;

			if (sleep < 0)
				sleep = 2;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
			beforeTime = System.currentTimeMillis();
		}
		gameOver();
	}

	private void animationCycle() {
		// player
		player.act();

		// shot
		if (shot != null) {
			if (shot.isVisible()) {
				int y = shot.getY() - SHOT_SPEED;
				shot.setY(y);
				if (y < 0) {
					shot.die();
					shot = null;
					System.out.println("Shot is gone!");
				}
			}
		}

		// wall

		// aliens
		aliens.stream()
			.filter(alien -> alien.isVisible())
			.forEach(alien -> alien.act());
		
		// bombs

	}

	private void gameOver() {
		// TODO Auto-generated method stub
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (ingame) {
			// Floor
			g.setColor(Color.GREEN);
			g.drawLine(0, APP_HEIGHT - APP_GROUND_HEIGHT, APP_WIDTH, APP_HEIGHT - APP_GROUND_HEIGHT);

			// Other Objects
			drawGameInfo(g);
			drawWall(g);
			drawAliens(g);
			drawPlayer(g);
			drawShot(g);
			drawBombing(g);

		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	private void drawGameInfo(Graphics g) {
		if (ingame) {
			g.setColor(Color.WHITE);
			g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 20));
			g.drawString("Aliens: " + aliens.size(), 10, this.getHeight() - 17);
		}
	}

	private void drawWall(Graphics g) {
		// TODO Auto-generated method stub

	}

	private void drawBombing(Graphics g) {
		// TODO Auto-generated method stub

	}

	private void drawShot(Graphics g) {
		if (shot != null) {
			if (shot.isVisible())
				g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
		}
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
		aliens.stream()
			.filter(alien -> alien.isVisible())
			.forEach(alien -> g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this));
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		player.keyPressed(ke);

		if (ingame) {
			if (ke.isControlDown()) {
				if (shot == null)
					shot = new Shot(player.getX(), player.getY());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		player.keyReleased(ke);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}
}
