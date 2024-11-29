import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;

public class MySketch extends PApplet {

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        background(200);
        ellipse(width / 2, height / 2, 50, 50);
    }

    public static void main(String[] args) {
        PApplet.main("MySketch");
    }
}