import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class MySketch1 extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
  size(1250, 600);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
    float division = (1/3)*width;

    // Draw the vertical line
    stroke(54, 71, 92); // Set the line color to black
    strokeWeight(5); // Set the line thickness
    line(division, 0, division, height); // Line from top to bottom of the screen
  }
  
  // define other methods down here.
}
