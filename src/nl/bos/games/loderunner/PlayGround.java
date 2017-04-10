package nl.bos.games.loderunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/*
 * Created by bosa on 29-3-2017.
 */
public class PlayGround extends JPanel {
    private final static Color BACKGROUND_COLOR = new Color(0, 0, 0);
    private Ground ground;
    private Player player;
    private PlayerKeyListener keyboard;
    private int playerSpriteNr = 0;
    private int playerSpeed = 0;
    private final static int SIZE_FACTOR = 160;
    private final static int PLAYER_SPRITE_START_RIGHT = 1;
    private final static int PLAYER_SPRITE_END_RIGHT = 3;
    private final static int PLAYER_SPRITE_START_LEFT = 6;
    private final static int PLAYER_SPRITE_END_LEFT = 8;
    private final static int PLAYER_SPRITE_START_UP = 4;
    private final static int PLAYER_SPRITE_END_UP = 5;

    public PlayGround(int width, int height) {
        //this.setDoubleBuffered(true); //No Effect YET!
        this.setBackground(BACKGROUND_COLOR);
        this.setFocusable(true);

        //Init objects
        ground = new Ground(width / (SIZE_FACTOR / 3));
        player = new Player(50, ground.getHeight(), width / SIZE_FACTOR, 0, playerSpriteNr);

        playerSpeed = width / (SIZE_FACTOR / 2);
        keyboard = new PlayerKeyListener(player);
        this.addKeyListener(keyboard);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Ground
        ground.draw(g, this.getHeight(), this.getWidth());

        //Player
        player.draw(g, this.getHeight());
        keyboard.poll();

        //Player shot
        if (keyboard.keyDown(KeyEvent.VK_CONTROL)) {
            if(!player.getOnLadder())
                player.shoot(true);
        } else if (keyboard.keyUp(KeyEvent.VK_CONTROL)) {
            player.shoot(false);
        }

        //Player moves
        if (keyboard.keyDown(KeyEvent.VK_RIGHT)) {
            setSprite(PLAYER_SPRITE_START_RIGHT, PLAYER_SPRITE_END_RIGHT);
            player.setOnLadder(false);
            player.setSpeed(playerSpeed);
            player.moveLocationX();
        } else if (keyboard.keyDown(KeyEvent.VK_LEFT)) {
            setSprite(PLAYER_SPRITE_START_LEFT, PLAYER_SPRITE_END_LEFT);
            player.setOnLadder(false);
            player.setSpeed(-playerSpeed);
            player.moveLocationX();
        } else if (keyboard.keyDown(KeyEvent.VK_UP)) {
            setSprite(PLAYER_SPRITE_START_UP, PLAYER_SPRITE_END_UP);
            player.setOnLadder(true);
            player.setSpeed(playerSpeed);
            player.moveLocationY();
        } else if (keyboard.keyDown(KeyEvent.VK_DOWN)) {
            setSprite(PLAYER_SPRITE_START_UP, PLAYER_SPRITE_END_UP);
            player.setOnLadder(true);
            if (player.getLocationY() > ground.getHeight()) {
                player.setSpeed(-playerSpeed);
                player.moveLocationY();
            } else
                player.setSpriteNr(0);
        }
    }

    private void setSprite(int playerSpriteMin, int playerSpriteMax) {
        if (!(playerSpriteNr >= playerSpriteMin && playerSpriteNr <= playerSpriteMax))
            playerSpriteNr = playerSpriteMin;
        player.setSpriteNr(playerSpriteNr);
        playerSpriteNr++;
    }
}
