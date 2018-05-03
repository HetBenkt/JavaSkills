package nl.bos.games.tutorials.basics;

import lombok.Getter;
import lombok.extern.java.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static nl.bos.games.tutorials.basics.Settings.*;

@Log
public class Board extends JPanel implements Runnable, KeyListener {
    private transient Image imagePlayer;
    private transient Image imageMissile;
    private transient Image imageMonster;
    @Getter
    private transient Player player;
    private transient GameDrawings gameDrawings;
    private final transient List<Monster> monsters = new ArrayList<>();

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
        player = new Player(100, 100, imagePlayer, true, 0, 0, 10, imageMissile);
        gameDrawings = new GameDrawings();

        Thread animator = new Thread(this);
        animator.start();
    }

    private void loadImages() {
        ImageIcon imageIconPlayer = new ImageIcon("src/main/java/nl/bos/games//tutorials/basics/assets/player.png");
        imagePlayer = imageIconPlayer.getImage();
        ImageIcon imageIconMissile = new ImageIcon("src/main/java/nl/bos/games//tutorials/basics/assets/missile.png");
        imageMissile = imageIconMissile.getImage();
        ImageIcon imageIconMonster = new ImageIcon("src/main/java/nl/bos/games//tutorials/basics/assets/monster.png");
        imageMonster = imageIconMonster.getImage();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        gameDrawings.draw(graphics2D, this);

        for (Monster monster : monsters) {
            if (monster.isVisible())
                monster.draw(graphics2D);
        }

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

        //noinspection InfiniteLoopStatement
        while (true) {
            //Move player
            player.move();

            //Move missiles
            List<Missile> missiles = player.getMissiles();
            for (int i = 0; i < missiles.size(); i++) {
                Missile missile = missiles.get(i);
                if (missile.isVisible()) {
                    missile.move();
                    if(missile.getSpeedX() < MISSILE_MAX_SPEED)
                        missile.setSpeedX(missile.getSpeedX()+1);
                }
                else
                    missiles.remove(i);
            }

            //Add monsters
            if(new Random().nextInt(100) == 1)
                monsters.add(new Monster(BOARD_WIDTH, new Random().nextInt(BOARD_WIDTH), imageMonster, true, 1, 0, 18));

            //Move monsters
            for (int i = 0; i < monsters.size(); i++) {
                Monster monster = monsters.get(i);
                if (monster.isVisible()) {
                    monster.move();
                }
                else
                    monsters.remove(i);
            }

            checkCollisions();

            this.repaint();

            diffTime = System.currentTimeMillis() - beforeTime;
            sleep = GAME_DELAY - diffTime;
            try {
                if(sleep <=0)
                    sleep = 2;
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

    private void checkCollisions() {
        //Player vs. Monster
        Rectangle playerBounds = player.getBounds();
        for (Monster monster : monsters) {
            Rectangle monsterBounds = monster.getBounds();
            if(playerBounds.intersects(monsterBounds)) {
                log.info("I'm HIT!!");
                monster.setVisible(false);
            }
        }

        //Missile vs. Monster
        for(Missile missile : player.getMissiles()) {
            Rectangle missileBounds = missile.getBounds();
            for (Monster monster : monsters) {
                Rectangle monsterBounds = monster.getBounds();
                if (missileBounds.intersects(monsterBounds)) {
                    log.info("Monster HIT!!");
                    monster.setVisible(false);
                    missile.setVisible(false);
                }
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
