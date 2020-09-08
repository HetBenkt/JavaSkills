package nl.bos.games.examples;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;

public class Example6 extends Application {
    private static final int APP_WIDTH = 800;
    private static final int APP_HEIGHT = 600;
    private ArrayList<String> input = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SpriteSheet Example");
        Scene scene = new Scene(createContent());

        scene.setOnKeyPressed(e -> {
            String code = e.getCode().toString();

            // only add once... prevent duplicates
            if (!input.contains(code))
                input.add(code);
        });

        scene.setOnKeyReleased(e -> {
            String code = e.getCode().toString();
            input.remove(code);
        });

        stage.setScene(scene);
        stage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setStyle("-fx-background-color: lightskyblue");
        Canvas canvas = new Canvas(APP_WIDTH, APP_HEIGHT);
        root.getChildren().addAll(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Sprite player = new Sprite();
        player.setImage(Sprite.getImage(1, 200, 200, "mario_sheet.png")[0]);
        player.setPosition(50, APP_HEIGHT - 200);

        ArrayList<Sprite> brickList = new ArrayList<Sprite>();

        for (int i = 0; i < 15; i++) {
            Sprite brick = new Sprite();
            brick.setImage("earth.png");
            brick.setPosition(i*brick.getBoundary().getWidth(), APP_HEIGHT-50);
            brickList.add(brick);
        }

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017), // 60 FPS
                ae -> {

                    // game logic
                    player.setVelocity(0, 0);
                    if (input.contains("LEFT")) {
                        player.addVelocity(-1, 0);
                    }
                    if (input.contains("RIGHT")) {
                        player.addVelocity(1, 0);
                    }
                    player.update(2);

                    // collision detection
                    Iterator<Sprite> moneybagIter = brickList.iterator();
                    while (moneybagIter.hasNext()) {
                        Sprite moneybag = moneybagIter.next();
                        if (player.intersects(moneybag)) {
                            moneybagIter.remove();
                        }
                    }

                    // Render
                    gc.clearRect(0, 0, APP_WIDTH, APP_HEIGHT);
                    player.render(gc);
                    for (Sprite moneybag : brickList)
                        moneybag.render(gc);
                });

        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
