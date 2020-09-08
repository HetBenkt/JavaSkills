package nl.bos.games.examples;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Sprite {
    private Image image;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    public Sprite() {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
    }

    public void setImage(Image image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
    }

    public void setImage(String filename) {
        Image image = new Image(filename);
        setImage(image);
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setVelocity(double velocityX, double velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time) {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, positionX, positionY, 100, 100);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, width, height);
    }

    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public String toString() {
        return " Position: [" + positionX + "," + positionY + "]"
                + " Velocity: [" + velocityX + "," + velocityY + "]";
    }

    /*
suppose i have an image strip of 10 frames of 32x32 ( 320x32 ), then i want to separate all frames in individual images
getImage( 10, 32,32,"myStrip.png" );
*/
    public static Image[] getImage( int frames, int w, int h,  String pathFile )
    {

        Image[] imgs =  new Image[ frames ];

        //img that contains all frames
        Image stripImg = new Image( pathFile );
        PixelReader pr =  stripImg.getPixelReader();
        PixelWriter pw = null;

        for( int i = 0; i < frames ; i++)
        {

            WritableImage wImg = new WritableImage( w, h );

            pw = wImg.getPixelWriter();

            for( int readY = 0 ; readY < h; readY++ )
            {

                int ww = (w * i);
                for( int readX = ww; readX < ww + w; readX++ )
                {
                    //get pixel at X  & Y position
                    Color color = pr.getColor( readX, readY );

                    //set pixel to writableimage through pixel writer
                    pw.setColor(readX - ww, readY, color);

                }//X


            }//Y


            //finally new image is stored
            imgs[ i ] = wImg;
        }//


        stripImg = null;
        pr = null;
        pw = null;

        return imgs;
    }//
}
