package nl.bos.games.tutorials.basics;

import javax.swing.*;

public class Application extends JFrame {
    private static final String APP_TITLE = "My app";

    public Application() {
        initUI();
    }

    private void initUI() {
        this.add(new Board());

        this.setResizable(false);
        this.pack();
        this.setTitle(APP_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.setVisible(true);
    }
}
