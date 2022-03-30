package nl.bos.fx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

class MyMouseHandler implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        System.out.println(event.getSource());
    }
}
