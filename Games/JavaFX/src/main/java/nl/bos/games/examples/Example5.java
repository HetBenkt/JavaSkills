package nl.bos.games.examples;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;

public class Example5 extends Application {
    private ArrayList<String> input = new ArrayList<>();
    private int points = 0;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Keyboard Example");
        Scene scene = new Scene(createContent());

        scene.setOnKeyPressed(e -> {
                    String code = e.getCode().toString();

                    // only add once... prevent duplicates
                    if ( !input.contains(code) )
                        input.add( code );
                });

        scene.setOnKeyReleased(e -> {
                    String code = e.getCode().toString();
                    input.remove( code );
                });

        stage.setScene(scene);
        stage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        Canvas canvas = new Canvas(512, 512);
        root.getChildren().addAll(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Sprite briefcase = new Sprite();
        briefcase.setImage("ufo_1.png");
        briefcase.setPosition(200, 0);

        ArrayList<Sprite> moneybagList = new ArrayList<Sprite>();

        for (int i = 0; i < 15; i++)
        {
            Sprite moneybag = new Sprite();
            moneybag.setImage("earth.png");
            double px = 350 * Math.random() + 50;
            double py = 350 * Math.random() + 50;
            moneybag.setPosition(px,py);
            moneybagList.add( moneybag );
        }

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );

        final long timeStart = System.currentTimeMillis();

        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),                // 60 FPS
                ae -> {
                    // calculate time since last update.
                    //double elapsedTime = (System.currentTimeMillis() - timeStart) / 1000.0;

                    // game logic
                    briefcase.setVelocity(0,0);
                    if (input.contains("LEFT")) {
                        briefcase.addVelocity(-1,0);
                    }
                    if (input.contains("RIGHT")) {
                        briefcase.addVelocity(1, 0);
                    }
                    if (input.contains("UP")) {
                        briefcase.addVelocity(0,-1);
                    }
                    if (input.contains("DOWN")) {
                        briefcase.addVelocity(0,1);
                    }
                    briefcase.update(1);

                    // collision detection
                    Iterator<Sprite> moneybagIter = moneybagList.iterator();
                    while ( moneybagIter.hasNext() )
                    {
                        Sprite moneybag = moneybagIter.next();
                        if ( briefcase.intersects(moneybag) )
                        {
                            moneybagIter.remove();
                            points++;
                        }
                    }

                    // Render
                    gc.clearRect(0, 0, 512,512);
                    briefcase.render( gc );
                    for (Sprite moneybag : moneybagList )
                        moneybag.render( gc );

                    gc.setFill( Color.BLUE );
                    String pointsText = "Points: " + points;
                    gc.fillText( pointsText, 10, 50 );
                    gc.strokeText( pointsText, 10, 50 );
                });

        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
