package nl.bos.fx;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Box;

class MyKeyHandler implements EventHandler<KeyEvent> {
    private final Box box;

    public MyKeyHandler(Box box) {
        this.box = box;
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event.getCode());

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
                System.out.println("No correct key");
        }
    }
}
