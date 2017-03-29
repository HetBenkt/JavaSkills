package nl.bos.games.loderunner;

import javax.swing.*;
import java.awt.*;

/*
 * Created by bosa on 29-3-2017.
 */
public class PlayGround extends JPanel {
    private final static Color BACKGROUND_COLOR = new Color(0,0,0);

    public PlayGround() {
        this.setBackground(BACKGROUND_COLOR);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Ground
        Ground ground = new Ground(10);
        ground.draw(g, this.getHeight(), this.getWidth());

        //Player
        Player player = new Player(50, ground.getHeight(), 50);
        player.draw(g, this.getHeight());
    }
}
