package nl.bos;

import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Frame extends Parent {
    private static final int PIXEL_SIZE = 10;
    private static final int PIXEL_OFFSET = 12;

    public Frame(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split("");
            for (int j = 0; j < split.length; j++) {
                if (!split[j].equals("X")) {
                    Rectangle rectangle = new Rectangle(PIXEL_SIZE, PIXEL_SIZE);
                    rectangle.setTranslateX(j * PIXEL_OFFSET);
                    rectangle.setTranslateY(i * PIXEL_OFFSET);
                    this.getChildren().add(rectangle);
                }
            }
        }
    }
}
