package nl.bos.games.loderunner;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/*
 * Created by bosa on 29-3-2017.
 */
public class Player {
    private int locationX;
    private int speed;
    private int locationY;
    private int blockSize;
    private int spriteNr;
    private final static Color PLAYER_COLOR = Color.WHITE;
    private final static int MAX_SPRITE_BLOCK_SIZE = 10;
    private final static String SPRITE_START_TAG = "===START";
    private final static String SPRITE_END_TAG = "===END";
    private static final String SPRINT_RIGHT_TAG = "RIGHT";
    private final static String SPRITES_FILE_NAME = "playersprites.txt";
    private final static String SPRITES_FILE_NAME_CHARSET = "UTF-8";
    private ArrayList<ArrayList<String>> sprites;

    public Player(int locationX, int locationY, int blockSize, int speed, int spriteNr) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.blockSize = blockSize;
        this.speed = speed;
        this.spriteNr = spriteNr;

        sprites = loadSprites();
    }

    private ArrayList<ArrayList<String>> loadSprites() {
        ArrayList<ArrayList<String>> sprites = new ArrayList< ArrayList<String>>();
        InputStream is = getClass().getResourceAsStream(SPRITES_FILE_NAME);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, SPRITES_FILE_NAME_CHARSET));
            boolean eof = false;
            int spriteNr = 0;
            int spriteindex = 0;
            ArrayList<String> sprite = null;
            while(!eof) {
                String text = br.readLine();
                if(text == null)
                    eof = true;
                else {
                    if(text.startsWith(SPRITE_START_TAG)) {
                        sprite = new ArrayList<String>();
                    } else if(text.startsWith(SPRITE_END_TAG)) {
                        sprites.add(spriteindex, sprite);
                        spriteNr++;
                        spriteindex++;
                        if(text.contains(SPRINT_RIGHT_TAG)) {
                            sprites.add(makeLeftVersion(sprite));
                            spriteNr++;
                        }
                    }
                    else {
                        sprite.add(text);
                    }
                }
            }
            System.out.println(String.format("No. of sprites loaded: %s", spriteNr));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sprites;
    }

    private ArrayList<String> makeLeftVersion(ArrayList<String> sprite) {
        ArrayList<String> result = new ArrayList<String>();
        for (String spriteRow:sprite) {
            result.add(mirrorText(spriteRow));
        }
        return result;
    }

    private String mirrorText(String spriteRow) {
        StringBuilder result = new StringBuilder();
        char[] spriteChars = spriteRow.toCharArray();
        for (int i = spriteChars.length-1; i >= 0; i--) {
            result.append(spriteChars[i]);
        }
        return result.toString();
    }

    public void draw(Graphics g, int playGroundHeight) {
        g.setColor(PLAYER_COLOR);
        ArrayList<String> spriteStandStill = sprites.get(spriteNr);
        int lineNumber = MAX_SPRITE_BLOCK_SIZE;
        for (String spriteLine:spriteStandStill) {
            lineNumber--;
            char[] blocks = spriteLine.toCharArray();
            int blockNumber = 0;
            for (char block:blocks) {
                if(block == 'x')
                    g.fillRect(locationX + (blockSize*blockNumber), playGroundHeight-locationY-blockSize - (blockSize * lineNumber), blockSize, blockSize);
                blockNumber++;
            }
        }
    }

    public void moveLocationX() {
        locationX += speed;
    }

    public void moveLocationY() {
        locationY += speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setSpriteNr(int spriteNr) {
        this.spriteNr = spriteNr;
    }
}
