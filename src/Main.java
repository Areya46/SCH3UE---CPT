import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.Arrays;

/**
 * Main class to execute sketch
 * @author 
 *
 */
class Main {
  public static void main(String[] args) {
    //LifeLinkER: An algorithmic ER patient tracking system for live updates and priority optimization
    String[] processingArgs = {"MySketch"};
	  MySketch MySketch = new MySketch();  //comment this out to run the other sketch files

	  // Sketch1 mySketch = new Sketch1();  // uncomment this to run this sketch file
	  // Sketch2 mySketch = new Sketch2();  // uncomment this to run this sketch file
	  
	  PApplet.runSketch(processingArgs, MySketch);
  }
  
}
