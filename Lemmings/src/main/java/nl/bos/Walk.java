package nl.bos;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class Walk extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final Logger logger = Logger.getLogger(Walk.class.getName());
    private final Pane root = new Pane();
    private final Lemming lemming = new Lemming(100, HEIGHT - (10 * 10)); //10 pixels or each 10 pixel height

    @Override
    public void start(Stage stage) {
        logger.info("Game started...");
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(key -> {
            switch (key.getCode()) {
                case LEFT -> lemming.moveLeft();
                case RIGHT -> lemming.moveRight();
                default -> throw new UnsupportedOperationException("Unsupported key");
            }
        });
        scene.setOnKeyReleased(key -> lemming.halt());
        stage.setScene(scene);
        stage.show();
    }

    private Parent createContent() {
        root.setPrefSize(WIDTH, HEIGHT);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        root.getChildren().add(lemming);
        return root;
    }
}