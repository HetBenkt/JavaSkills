package nl.bos;

import javafx.application.Application;
import javafx.application.Platform;
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
        //todo run multiple instances to see what will happen!
        launch(args);

        //todo Add JUnit5 tests
        //todo check for the single responsibility principle in big classes and large methods!
        //todo convert methods to functional methods!
        //todo see if the an abstracted class can play with generics
    }

    private static void shutdown() {
        System.out.println("Shutdown hook");
        connectionFactory.disconnect();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Onion CRUD App");
        primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/nl/bos/presentation/views/AppView.fxml"))), 800, 600));
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            System.out.println("handle() method");
            Platform.exit();
            //System.exit(0); //not needed as stop() is automatically called!
        });
    }

    @Override
    public void stop() {
        System.out.println("stop() method");
        connectionFactory.disconnect();
    }
}