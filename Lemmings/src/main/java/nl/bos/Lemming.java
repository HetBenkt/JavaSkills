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

    private static final double MOVE = 10;
    private static final int SPEED = 5; //less is faster
    private static final List<Frame> frames = new ArrayList<>();
    private static final List<String> data = new ArrayList<>();
    private final AnimationTimer timer;
    private int frameNr = 0;
    private int fps = 0;
    private boolean isMoveRight = false;
    private boolean isMoveLeft = false;

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
        this.getChildren().add(frames.get(frameNr));

        if (fps % SPEED == 0) {
            fps = 0;
            frameNr++;
            if (frameNr == frames.size()) {
                frameNr = 0;
            }
            if (isMoveRight) {
                this.setTranslateX(getTranslateX() + MOVE);
            }
            if (isMoveLeft) {
                this.setTranslateX(getTranslateX() - MOVE);
            }
        }
    }

    protected void moveLeft() {
        isMoveRight = false;
        isMoveLeft = true;
        timer.start();
    }

    protected void moveRight() {
        isMoveRight = true;
        isMoveLeft = false;
        timer.start();
    }

    protected void halt() {
        timer.stop();
    }
}