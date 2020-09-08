package nl.bos.games.examples;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Example3_1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Timeline Example");
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image earth = new Image("earth.png");
        Image sun = new Image("sun.png");
        Image space = new Image("space.png");

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );

        final long timeStart = System.currentTimeMillis();

        AnimatedImage ufo = new AnimatedImage(null);
        Image[] imageArray = new Image[6];
        for (int i = 0; i < 6; i++) {
            imageArray[i] = new Image("ufo_" + (i+1) + ".png");
        }
        ufo.setFrames(imageArray);
        ufo.setDuration(0.100);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),                // 60 FPS
                ae -> {
                    double t = (System.currentTimeMillis() - timeStart) / 1000.0;

                    double x = 232 + 128 * Math.cos(t);
                    double y = 232 + 128 * Math.sin(t);

                    // Clear the canvas
                    gc.clearRect(0, 0, 512,512);

                    // background image clears canvas
                    gc.drawImage( space, 0, 0 );
                    gc.drawImage( earth, x, y );
                    gc.drawImage( sun, 196, 196 );
                    gc.drawImage( ufo.getFrame(t), 450, 25 );
                });

        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
