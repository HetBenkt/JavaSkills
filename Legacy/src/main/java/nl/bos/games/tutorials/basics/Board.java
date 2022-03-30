package nl.bos.games.tutorials.basics;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static nl.bos.games.tutorials.basics.Settings.*;

public class Board extends JPanel implements Runnable, KeyListener {
    private transient Image imagePlayer;
    private transient Image imageMissile;
    private transient Image imageMonster;
    private transient Image imageBackground;
    private Media soundBackground;
    private Media soundRocket;

    private transient Player player;
    private transient GameDrawings gameDrawings;
    private final transient List<Monster> monsters = new ArrayList<>();

    public Player getPlayer() {
        return player;
    }

    public Board() {
        initBoard();
    }

    private void initBoard() {
        //Load the assets
        loadImages();
        loadSounds();

        //Mkae the board settings
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        this.setDoubleBuffered(true);

        //Initiate playable game
        player = new Player(new Point(100, 100), imagePlayer, true, 0, 0, 10, imageMissile, soundRocket);
        gameDrawings = new GameDrawings();

        //Start the background music
        MediaPlayer mediaPlayer = new MediaPlayer(soundBackground);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        //Run the animator thread/game loop
        Thread animator = new Thread(this);
        animator.start();
    }

    private void loadSounds() {
        //Avoids javaFX error: Toolkit not initialized
        new JFXPanel();

        String backgroundMp3 = new File("src/main/java/nl/bos/games//tutorials/basics/assets/background.mp3").toURI().toString();
        soundBackground = new Media(backgroundMp3);
        String rocketMp3 = new File("src/main/java/nl/bos/games//tutorials/basics/assets/rocket.mp3").toURI().toString();
        soundRocket = new Media(rocketMp3);

    }

    private void loadImages() {
        ImageIcon imageIconBackground = new ImageIcon("src/main/java/nl/bos/games//tutorials/basics/assets/background.jpg");
        imageBackground = imageIconBackground.getImage();
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

        graphics2D.drawImage(imageBackground, 0, 0, BOARD_WIDTH, BOARD_HEIGHT, null);
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
            moveAndAddMonsters();

            checkCollisions();

            this.repaint();

            diffTime = System.currentTimeMillis() - beforeTime;
            sleep = GAME_DELAY - diffTime;
            try {
                if(sleep <=0)
                    sleep = 2;
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                Thread.currentThread().interrupt();
            } finally {
                beforeTime = System.currentTimeMillis();
            }
        }
    }

    private void moveAndAddMonsters() {
        //Move player
        player.move();

        //Move missiles
        List<Missile> missiles = player.getMissiles();
        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);
            if (missile.isVisible()) {
                missile.move();
                if (missile.getSpeedX() < MISSILE_MAX_SPEED)
                    missile.setSpeedX(missile.getSpeedX() + 1);
            } else
                missiles.remove(i);
        }

        //Add monsters
        if (new Random().nextInt(100) == 1) {
            Point monsterPoint = new Point(BOARD_WIDTH, new Random().nextInt(BOARD_WIDTH));
            monsters.add(new Monster(monsterPoint, imageMonster, true, 1, 0, 18));
        }

        //Move monsters
        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
            if (monster.isVisible()) {
                monster.move();
            } else
                monsters.remove(i);
        }
    }

    private void checkCollisions() {
        //Player vs. Monster
        Rectangle playerBounds = player.getBounds();
        for (Monster monster : monsters) {
            Rectangle monsterBounds = monster.getBounds();
            if(playerBounds.intersects(monsterBounds)) {
                System.out.println("I'm HIT!!");
                monster.setVisible(false);
            }
        }

        //Missile vs. Monster
        for(Missile missile : player.getMissiles()) {
            Rectangle missileBounds = missile.getBounds();
            for (Monster monster : monsters) {
                Rectangle monsterBounds = monster.getBounds();
                if (missileBounds.intersects(monsterBounds)) {
                    System.out.println("Monster HIT!!");
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
