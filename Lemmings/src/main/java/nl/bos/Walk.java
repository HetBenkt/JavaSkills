package nl.bos;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Walk extends Application {
    private static final Logger logger = Logger.getLogger(Walk.class.getName());

    private static final List<String> data = new ArrayList<>();
    private static final List<nl.bos.Frame> frames = new ArrayList<>();

    static {
        InputStream is;
        is = Walk.class.getClassLoader().getResourceAsStream("frames");

        try (InputStreamReader streamReader = new InputStreamReader(
                Objects.requireNonNull(is),
                StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new LemmingsException("Frames input not found!", e);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        initFrames();
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private void initFrames() {
        for (int i = 0; i < data.size(); i += 10) {
            frames.add(new Frame(data.subList(i, i + 10)));
        }
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(800, 600);

        Frame frame1 = frames.get(0);
        frame1.setTranslateX(100);
        frame1.setTranslateY(100);

        root.getChildren().add(frame1);
        return root;
    }
}
