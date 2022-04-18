package nl.bos;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;

public class Lemming extends Parent {

    private static final double MOVE = 10;
    private static final int SPEED = 5; //less is faster
    private final AnimationTimer timer;
    private int frameNr = 0;
    private int updateIndex = 0;
    private boolean isMoveRight = false;
    private boolean isMoveLeft = false;
    private final Frames framesWalk = new Frames("frames-walk");
    private final Frames framesHalt = new Frames("frames-halt");
    private State state = State.HALT_RIGHT;

    public Lemming(int x, int y) {
        this.setTranslateX(x);
        this.setTranslateY(y);

        timer = new AnimationTimer() {
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
        if (isMoveRight) {
            this.getChildren().add(framesWalk.getFramesRight().get(frameNr));
        } else if (isMoveLeft) {
            this.getChildren().add(framesWalk.getFramesLeft().get(frameNr));
        } else if (state == State.HALT_RIGHT) {
            this.getChildren().add(framesHalt.getFramesRight().get(frameNr));
        } else if (state == State.HALT_LEFT) {
            this.getChildren().add(framesHalt.getFramesLeft().get(frameNr));
        }

        if (updateIndex % SPEED == 0) {
            updateIndex = 0;
            frameNr++;
            if (frameNr == framesWalk.getFramesRight().size()) {
                frameNr = 0;
            }
            if (isMoveRight) {
                this.setTranslateX(getTranslateX() + MOVE);
                state = State.HALT_RIGHT;
            } else if (isMoveLeft) {
                this.setTranslateX(getTranslateX() - MOVE);
                state = State.HALT_LEFT;
            }
        }
    }

    protected void moveLeft() {
        isMoveRight = false;
        isMoveLeft = true;
    }

    protected void moveRight() {
        isMoveRight = true;
        isMoveLeft = false;
    }

    protected void halt() {
        isMoveRight = false;
        isMoveLeft = false;
    }
}