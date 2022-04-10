package nl.bos;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Frame extends Parent {
    private static final int PIXEL_SIZE = 10;
    private static final int PIXEL_OFFSET = 10;

    public Frame(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split("");
            for (int j = 0; j < split.length; j++) {
                if (!split[j].equals("X")) {
                    Rectangle rectangle = new Rectangle(PIXEL_SIZE, PIXEL_SIZE);
                    rectangleColor(split[j], rectangle);
                    rectangle.setTranslateX(j * PIXEL_OFFSET);
                    rectangle.setTranslateY(i * PIXEL_OFFSET);
                    this.getChildren().add(rectangle);
                }
            }
        }
    }

    private void rectangleColor(String colorCode, Rectangle rectangle) {
        switch (colorCode) {
            case "G" -> rectangle.setFill(Color.rgb(0, 168, 0));
            case "B" -> rectangle.setFill(Color.rgb(32, 56, 236));
            case "W" -> rectangle.setFill(Color.rgb(188, 188, 188));
            default -> rectangle.setFill(Color.BLACK);
        }
    }
}
