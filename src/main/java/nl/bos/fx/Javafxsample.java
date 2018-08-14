package nl.bos.fx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.stage.Stage;
import lombok.extern.java.Log;

@Log
public class Javafxsample extends Application {
    private Button btnHello;
    private Box box;
    private PerspectiveCamera camera;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        primaryStage.setTitle("My sample FX app");

        Group root = new Group();
        ObservableList<Node> children = root.getChildren();
        children.add(btnHello);
        children.add(box);

        Scene main = new Scene(root, 600, 300);
        main.setFill(Color.GREEN);
        main.setCamera(camera);
        main.setOnKeyPressed(new MyKeyHandler(box));

        primaryStage.setScene(main);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();

        camera = new PerspectiveCamera(false);
        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(0);

        btnHello = new Button("Hello");
        btnHello.setTranslateX(100);
        btnHello.setTranslateY(100);
        btnHello.setOnMouseClicked(new MyMouseHandler());

        box = new Box(60, 40, 30);
        box.setTranslateX(40);
        box.setTranslateY(40);
        box.setTranslateZ(0);
        box.setDrawMode(DrawMode.FILL);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        log.info("App is stopped!!");
    }
}
