package nl.bos;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lemming extends Parent {

    private static final double MOVE = 5;
    private static final int SPEED = 5;
    private static final List<Frame> frames = new ArrayList<>();
    private static final List<String> data = new ArrayList<>();

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

    private final AnimationTimer timer;
    private int frameNr = 0;
    private int fps = 0;

    public Lemming(int x, int y) {
        this.setTranslateX(x);
        this.setTranslateY(y);
        initFrames();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
    }

    private void initFrames() {
        for (int i = 0; i < data.size(); i += 10) {
            frames.add(new Frame(data.subList(i, i + 10)));
        }
    }

    private void onUpdate() {
        fps++;
        this.getChildren().clear();

        Frame frame = frames.get(frameNr);

        this.getChildren().add(frame);

        if (fps % SPEED == 0) {
            fps = 0;
            frameNr++;
            if (frameNr == frames.size()) {
                frameNr = 0;
            }
        }
    }

    protected void moveLeft() {
        this.setTranslateX(getTranslateX() - MOVE);
        timer.start();
    }

    protected void moveRight() {
        this.setTranslateX(getTranslateX() + MOVE);
        timer.start();
    }

    protected void halt() {
        timer.stop();
    }
}