package nl.bos.fx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import lombok.extern.java.Log;

@Log
class MyMouseHandler implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        log.info(String.valueOf(event.getSource()));
    }
}
