import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class MySketch2 extends PApplet {

    Random myRandom = new Random();

    // WelcomePage Variables
    PImage imgWelcomePage;
    PImage imgPatientNumber;
    PImage imgLoadingScreen;
    boolean blnGetStartedselected;
    
    //Set Up the screen size

    public void settings() {
        size(1250, 600);
    }

    public void setup() {
        //Set background colour
        background(232, 237, 250);
        loadPatientImages();
    }

    public void draw() {
        float division = width / parseFloat(3);

        background(232, 237, 250);

        // Draw the vertical line dividing the two sides of the screen
        stroke(106, 133, 166);
        strokeWeight(5); 
        line(division, 0, division, height); 

        // USER PART OF THE SCREEN
        if (blnGetStartedselected){
            patientNumebr();
        }
        if (!blnGetStartedselected){
            welcomePage();
        }
    }
      
    public static void main(String[] args) {
        PApplet.main("MySketch");
    }

    public void welcomePage(){
        image(imgWelcomePage, 25, 30);
        image(imgLoadingScreen, 25, 30);
    }

    public void loadPatientImages(){

        // Welcome page 
        imgWelcomePage = loadImage("/Images/WelcomePage.png");
        imgWelcomePage.resize(350, 515);

        // Insert patient number
        imgPatientNumber = loadImage("/Images/pleaseEnterPatientNumber.png");
        imgPatientNumber.resize(width, height);

        // Insert patient number
        imgLoadingScreen = loadImage("/Images/LoadingScreen.png");
        imgLoadingScreen.resize(width, height);
    }

    public void patientNumebr(){
        // Text saying to enter patient number below
        image(imgPatientNumber, 0, 20);

        // Line where number will be enteredss
    }

    public void mouseClicked(){
        if (mouseX >= 100 && mouseX <= 320 && mouseY >= 330 && mouseY <= 380){
            blnGetStartedselected = true;
        }
    }

    public void mouseDragged(){}
    
    public void keyPressed(){}
    
    public void keyReleased(){}
    
    public void keyTyped(){}
}