package nl.bos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.bos.data.ConnectionFactory;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

    private static final ConnectionFactory connectionFactory = ConnectionFactory.INSTANCE;

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(App::shutdown));
        connectionFactory.setInstanceVariables(args[0], args[1], args[2]);
        launch(args); //todo run multiple instances to see what will happen!
    }

    private static void shutdown() {
        connectionFactory.disconnect();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Onion CRUD App");
        primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/nl/bos/presentation/views/AppView.fxml"))), 800, 600));
        primaryStage.show();
    }

    @Override
    public void stop() {
        connectionFactory.disconnect();
    }
}