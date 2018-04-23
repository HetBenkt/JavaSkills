package nl.bos.games.tutorials.basics;

import lombok.Data;
import lombok.extern.java.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

@Data
@Log
public class Board extends JPanel implements Runnable, KeyListener {
    public static final int BOARD_WIDTH = 800;
    public static final int BOARD_HEIGHT = 600;
    private static final long DELAY = 40;
    private Image imagePlayer;
    private Image imageMissile;
    private Player player;
    private GameDrawings gameDrawings;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        this.setDoubleBuffered(true);

        loadImages();
        player = new Player(100, 100, imagePlayer, imageMissile, 0, 0);
        gameDrawings = new GameDrawings();

        Thread animator = new Thread(this);
        animator.start();
    }

    private void loadImages() {
        ImageIcon imageIconPlayer = new ImageIcon("src/main/java/nl/bos/games//tutorials/basics/player.png");
        imagePlayer = imageIconPlayer.getImage();
        ImageIcon imageIconMissile = new ImageIcon("src/main/java/nl/bos/games//tutorials/basics/missile.png");
        imageMissile = imageIconMissile.getImage();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        gameDrawings.draw(graphics2D, this);
        for (Missile missile : player.getMissiles()) {
            if (missile.isVisible())
                missile.draw(graphics2D);
        }
        player.draw(graphics2D);

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void run() {
        long diffTime;
        long sleep;
        long beforeTime = System.currentTimeMillis();

        while (true) {
            player.move();

            List<Missile> missiles = player.getMissiles();
            for (int i = 0; i < missiles.size(); i++) {
                Missile missile = missiles.get(i);
                if (missile.isVisible()) {
                    missile.move();
                    missile.setSpeedX(missile.getSpeedX()+1);
                }
                else
                    missiles.remove(i);
            }

            this.repaint();

            diffTime = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - diffTime;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                log.finest(e.getMessage());
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                Thread.currentThread().interrupt();
            } finally {
                beforeTime = System.currentTimeMillis();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Do nothing.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }
}
