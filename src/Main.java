import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Main class to execute sketch
 * @author 
 *
 */
class Main {
  public static void main(String[] args) {
    
    String[] processingArgs = {"MySketch1"};
	  MySketch1 mySketch1 = new MySketch1();  //comment this out to run the other sketch files
	  // Sketch1 mySketch = new Sketch1();  // uncomment this to run this sketch file
	  // Sketch2 mySketch = new Sketch2();  // uncomment this to run this sketch file
	  
	  PApplet.runSketch(processingArgs, mySketch1);
  }
  
}
