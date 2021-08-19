package nl.bos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.bos.business.IPersonService;
import nl.bos.business.PersonService;
import nl.bos.data.ConnectionFactory;
import nl.bos.data.PersonDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Set;

public class App extends Application {

    private static final ConnectionFactory connectionFactory = ConnectionFactory.INSTANCE;

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(App::shutdown));
        connectionFactory.setInstanceVariables(args[0], args[1], args[2]);
        launch(args);
    }

    private static void shutdown() {
        connectionFactory.disconnect();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/nl/bos/presentation/views/sample.fxml"))), 800, 600));
        primaryStage.show();

        IPersonService personService = new PersonService();
        Set<String> interests = Set.of("Books", "Software", "Running");
        PersonDTO person = new PersonDTO("John Doe", 33, interests);
        try {
            personService.create(person);
        } catch (SQLException ex) {
            throw new RuntimeException("Error creating a person", ex);
        }
    }
}