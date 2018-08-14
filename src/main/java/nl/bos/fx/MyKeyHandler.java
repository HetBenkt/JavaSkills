package nl.bos.fx;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Box;
import lombok.extern.java.Log;

@Log
class MyKeyHandler implements EventHandler<KeyEvent> {
    private final Box box;

    public MyKeyHandler(Box box) {
        this.box = box;
    }

    @Override
    public void handle(KeyEvent event) {
        log.info(String.valueOf(event.getCode()));

        double speed = 5;

        switch (event.getCode()) {
            case LEFT:
                box.setTranslateX(box.getTranslateX() - speed);
                break;
            case RIGHT:
                box.setTranslateX(box.getTranslateX() + speed);
                break;
            case UP:
                box.setTranslateY(box.getTranslateY() - speed);
                break;
            case DOWN:
                box.setTranslateY(box.getTranslateY() + speed);
                break;
            default:
                log.info("No correct key");
        }
    }
}
