package nl.bos;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
    private static final int SPEED = 5;
    private final Pane root = new Pane();
    private int frameNr = 0;
    private int fps = 0;

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
        logger.info("Game started...");
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
        root.setPrefSize(800, 600);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();

        return root;
    }

    private void onUpdate() {
        fps++;
        root.getChildren().clear();

        Frame frame = frames.get(frameNr);
        frame.setTranslateX(100);
        frame.setTranslateY(100);

        root.getChildren().add(frame);

        if (fps % SPEED == 0) {
            frameNr++;
            if (frameNr == frames.size()) {
                frameNr = 0;
            }
        }
    }
}
