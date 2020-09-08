package nl.bos.games.examples;

import javafx.application.Application;
import javafx.stage.Stage;

public class Example1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello, world!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
