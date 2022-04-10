package nl.bos;

import javafx.scene.Parent;
import javafx.scene.shape.Circle;

import java.util.List;

public class Frame extends Parent {

    public Frame(List<String> lines) {
        this.getChildren().add(new Circle(10));
    }
}
