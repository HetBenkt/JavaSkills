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
    private final static int PLAYER_SPEED = 10;
    private final static int PLAYER_SPRITE_MIN_RIGHT = 1;
    private final static int PLAYER_SPRITE_MAX_RIGHT = 3;
    private final static int PLAYER_SPRITE_MIN_LEFT = 4;
    private final static int PLAYER_SPRITE_MAX_LEFT = 6;
    private final static int PLAYER_SPRITE_MIN_UP = 7;
    private final static int PLAYER_SPRITE_MAX_UP = 8;

    public PlayGround() {
        //this.setDoubleBuffered(true); //No Effect YET!
        this.setBackground(BACKGROUND_COLOR);
        this.setFocusable(true);
        //this.requestFocusInWindow(); //TODO Check what it does?

        //Init objects
        ground = new Ground(15);
        player = new Player(50, ground.getHeight(), 5, 0, playerSpriteNr);
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
        if( keyboard.keyDown( KeyEvent.VK_RIGHT ) ) {
            setSprite(PLAYER_SPRITE_MIN_RIGHT, PLAYER_SPRITE_MAX_RIGHT);
            player.setSpeed(PLAYER_SPEED);
            player.moveLocationX();
        }
        else if( keyboard.keyDown( KeyEvent.VK_LEFT ) ) {
            setSprite(PLAYER_SPRITE_MIN_LEFT, PLAYER_SPRITE_MAX_LEFT);
            player.setSpeed(-PLAYER_SPEED);
            player.moveLocationX();
        }
        else if( keyboard.keyDown( KeyEvent.VK_UP ) ) {
            setSprite(PLAYER_SPRITE_MIN_UP, PLAYER_SPRITE_MAX_UP);
            player.setSpeed(PLAYER_SPEED);
            player.moveLocationY();
        }
        else if( keyboard.keyDown( KeyEvent.VK_DOWN ) ) {
            setSprite(PLAYER_SPRITE_MIN_UP, PLAYER_SPRITE_MAX_UP);
            if(player.getLocationY() > ground.getHeight()) {
                player.setSpeed(-PLAYER_SPEED);
                player.moveLocationY();
            } else
                player.setSpriteNr(0);
        }
    }

    private void setSprite(int playerSpriteMin, int playerSpriteMax) {
        if(!(playerSpriteNr >= playerSpriteMin && playerSpriteNr <= playerSpriteMax))
            playerSpriteNr = playerSpriteMin;
        player.setSpriteNr(playerSpriteNr);
        playerSpriteNr++;
    }
}
