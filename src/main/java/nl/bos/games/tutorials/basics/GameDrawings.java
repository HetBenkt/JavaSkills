package nl.bos.games.tutorials.basics;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.text.MessageFormat;

class GameDrawings {
    public void draw(Graphics2D graphics2D, Board board) {
        graphics2D.setColor(Color.BLUE);
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.draw(new Rectangle2D.Double(10, 10, Board.BOARD_WIDTH - 20, Board.BOARD_HEIGHT - 20));

        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(1));
        graphics2D.drawString(MessageFormat.format("x: {0}, y {1}", board.getPlayer().getLocationX(), board.getPlayer().getLocationY()), 20, 30);
    }
}