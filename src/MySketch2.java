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

    // Line where number will be enteredss
    String userInput = ""; // Variable to store the user input
    boolean isTyping = false; // Flag to indicate if user is typing
    int listSize = 0; // Variable for the size of the list
    public void patientNumebr(){
        // Text saying to enter patient number below
        image(imgPatientNumber, 0, 20);

        // Draw the text box
        fill(255, 203, 79);
        stroke(255, 149, 0);
        rect(50, 150, 200, 60); // Text box

        // Display the user's input
        fill(15, 47, 118);
        textSize(60);
        text(userInput, 60, 200);

        // Display the list size
        textSize(16);
        text("Patient Number: " + listSize, 50, 250);

        // Display the list size
        textSize(30);
        text("Current Patient's Number: " + listSize, 450, 50);

    }

    public void mouseClicked(){
        if (mouseX >= 100 && mouseX <= 320 && mouseY >= 330 && mouseY <= 380){
            blnGetStartedselected = true;
        }

        if (mouseX > 50 && mouseX < 250 && mouseY > 150 && mouseY < 210) {
          isTyping = true;
        } else {
          isTyping = false;
        }
    }

    public void mouseDragged(){}
    
    public void keyPressed(){
      if (isTyping) {
        if (key >= '0' && key <= '9') {
          // Add numeric input to the string
          userInput += key;
        } else if (key == BACKSPACE && userInput.length() > 0) {
          // Remove the last character on backspace
          userInput = userInput.substring(0, userInput.length() - 1);
        } else if (key == ENTER || key == RETURN) {
          // Convert input to a number and update list size
          if (!userInput.isEmpty()) {
            listSize = Integer.parseInt(userInput);
            userInput = ""; // Clear the input after setting the variable
          }
        }
      }
    }
    
    
    public void keyReleased(){}
    
    public void keyTyped(){}
}