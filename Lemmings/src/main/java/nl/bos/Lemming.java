package nl.bos;

import javafx.animation.AnimationTimer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;

public class Lemming extends Parent {

    private static final double MOVE = 10;
    private static final int SPEED = 5; //less is faster
    private final IntegerProperty location = new SimpleIntegerProperty();
    private int frameNr = 0;
    private int updateIndex = 0;
    private final Frames framesWalk = new Frames("frames-walk");
    private final Frames framesHalt = new Frames("frames-halt");
    private State state = State.HALT_RIGHT;

    public Lemming(int x, int y) {
        location.setValue(x);
        this.setTranslateX(x);
        this.setTranslateY(y);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();
    }

    private void onUpdate() {
        updateIndex++;
        this.getChildren().clear();

        switch (state) {
            case WALK_RIGHT -> this.getChildren().add(framesWalk.getFramesRight().get(frameNr));
            case WALK_LEFT -> this.getChildren().add(framesWalk.getFramesLeft().get(frameNr));
            case HALT_RIGHT -> this.getChildren().add(framesHalt.getFramesRight().get(frameNr));
            case HALT_LEFT -> this.getChildren().add(framesHalt.getFramesLeft().get(frameNr));
            default -> throw new UnsupportedOperationException("Unsupported state");
        }

        if (updateIndex % SPEED == 0) {
            updateIndex = 0;
            frameNr++;
            if (frameNr == framesWalk.getFramesRight().size()) {
                frameNr = 0;
            }
            if (state == State.WALK_RIGHT) {
                this.setTranslateX(getTranslateX() + MOVE);
                location.setValue(location.getValue() + MOVE);
            } else if (state == State.WALK_LEFT) {
                this.setTranslateX(getTranslateX() - MOVE);
                location.setValue(location.getValue() - MOVE);
            }
        }
    }

    protected void moveLeft() {
        state = State.WALK_LEFT;
    }

    protected void moveRight() {
        state = State.WALK_RIGHT;
    }

    protected void halt() {
        if (state == State.WALK_RIGHT) {
            state = State.HALT_RIGHT;
        } else if (state == State.WALK_LEFT) {
            state = State.HALT_LEFT;
        }
    }

    public IntegerProperty getLocation() {
        return location;
    }
}