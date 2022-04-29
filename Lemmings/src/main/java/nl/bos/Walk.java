package nl.bos;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        root.getChildren().add(infoDashboard(10, 10));
        root.getChildren().add(lemming);
        return root;
    }

    private Node infoDashboard(final int locationX, final int locationY) {
        StackPane pane = new StackPane();
        pane.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, null, null)));
        pane.setTranslateX(locationX);
        pane.setTranslateY(locationY);

        Label info = new Label("Info dashboard");
        info.setFont(new Font("Verdana", 18));
        info.setTextFill(Color.WHITESMOKE);
        info.textProperty().bind(lemming.getLocation().asString());

        pane.getChildren().add(info);

        return pane;
    }
}