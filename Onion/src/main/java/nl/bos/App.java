package nl.bos;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.bos.data.ConnectionFactory;

public class App extends Application {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(App::shutdown));
        launch(args);
    }

    private static void shutdown() {
        ConnectionFactory.INSTANCE.disconnect();
    }

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    //TODO Should move to a MVC presentation layer!
    private Parent createContent() {
        VBox root = new VBox();
        root.setPrefSize(1280, 720);
        return root;
    }
}