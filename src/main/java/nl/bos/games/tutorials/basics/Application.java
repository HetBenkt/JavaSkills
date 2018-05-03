package nl.bos.games.tutorials.basics;

import javax.swing.*;

import static nl.bos.games.tutorials.basics.Settings.GAME_TITLE;

public class Application extends JFrame {

    private Application() {
        initUI();
    }

    private void initUI() {
        this.add(new Board());

        this.setResizable(false);
        this.pack();
        this.setTitle(GAME_TITLE);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.setVisible(true);
    }
}
