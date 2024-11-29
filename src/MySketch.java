import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class MySketch extends PApplet {

    Random myRandom = new Random();

    //Set Up the screen size
    public void settings() {
        size(1400, 800);
    }

    //This is where all the buttons will be 
    public void draw() {
        
    }

    public void setup() {
        //Set background colour
        background(232, 237, 250);
        //Load images
    }
      

    public static void main(String[] args) {
        PApplet.main("MySketch");
    }

    public void mouseDragged(){}
    public void mouseClicked(){}
    public void keyPressed(){}
    public void keyReleased(){}
    public void keyTyped(){}
}