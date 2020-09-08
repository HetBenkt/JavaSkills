package nl.bos.games.examples;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class Example4 extends Application {
    private ArrayList<String> input = new ArrayList<>();
    private Circle targetData = new Circle();
    private int points = 0;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Keyboard Example");
        Scene scene = new Scene(createContent());
        targetData.setRadius(40.0f);
        targetData.setStroke(Color.RED);
        targetData.setFill(Color.YELLOW);
        targetData.setStrokeWidth(2);

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

        scene.setOnMouseClicked(
                e -> {
                    if ( targetData.contains( e.getX(), e.getY() ) )  {
                        double x = 50 + 400 * Math.random();
                        double y = 50 + 400 * Math.random();
                        //targetData.setCenter(x,y);
                        points++;
                    } else
                        points--;
                });

        stage.setScene(scene);
        stage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        Canvas canvas = new Canvas(512, 512);
        root.getChildren().addAll(targetData, canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image earth = new Image("earth.png");
        Image sun = new Image("sun.png");
        Image space = new Image("space.png");

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );

        final long timeStart = System.currentTimeMillis();

        AnimatedImage ufo = new AnimatedImage(new Point2D(30, 30));
        Image[] imageArray = new Image[6];
        for (int i = 0; i < 6; i++) {
            imageArray[i] = new Image("ufo_" + (i+1) + ".png");
        }
        ufo.setFrames(imageArray);
        ufo.setDuration(0.100);

        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),                // 60 FPS
                ae -> {
                    double t = (System.currentTimeMillis() - timeStart) / 1000.0;

                    double x = 232 + 128 * Math.cos(t);
                    double y = 232 + 128 * Math.sin(t);

                    // Clear the canvas
                    gc.clearRect(0, 0, 512,512);

                    if (input.contains("LEFT")) {
                        ufo.moveHorizontal(-1);
                    } else
                        ufo.moveHorizontal(0);
                    if (input.contains("RIGHT"))
                        ufo.moveHorizontal(1);
                    else
                        ufo.moveHorizontal(0);
                    if (input.contains("UP")) {
                        ufo.moveVertical(-1);
                    } else
                        ufo.moveVertical(0);
                    if (input.contains("DOWN"))
                        ufo.moveVertical(1);
                    else
                        ufo.moveVertical(0);

                    // background image clears canvas
                    //gc.drawImage( space, 0, 0 );
                    gc.drawImage( earth, x-(earth.getWidth()/2), y-(earth.getHeight()/2));
                    targetData.setCenterX(x);
                    targetData.setCenterY(y);
                    gc.drawImage( sun, 196, 196 );
                    gc.drawImage( ufo.getFrame(t), ufo.getLocation().getX(), ufo.getLocation().getY());

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
