import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.Arrays;

public class MySketch2 extends PApplet {

    Random myRandom = new Random();

    // WelcomePage Variables
    PImage imgWelcomePage;
    PImage imgPatientNumber;
    boolean blnGetStartedselected;

    // Line where number will be enteredss
    String userInput = ""; // Variable to store the user input
    boolean isTyping = false; // Flag to indicate if user is typing
    int currentPatient = 0; // Variable for the size of the list
    int reprint = 0;

    int amount = 0;
    boolean showname = true;
    boolean checkbutton = true;
    boolean showPatient = true;
    int[] patientsNum = new int[20];
    String[] firstNames = {
        "John", "Emily", "Michael", "Sophia", "David", "Olivia", 
        "James", "Isabella", "Daniel", "Mia", "Ethan", "Ava", 
        "Alexander", "Charlotte", "Benjamin", "Amelia", "Lucas", 
        "Harper", "Henry", "Ella"
    };

    String[] lastNames = {
        "Smith", "Johnson", "Brown", "Williams", "Jones", "Garcia", 
        "Miller", "Davis", "Martinez", "Hernandez", "Lopez", "Gonzalez", 
        "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", 
        "White", "Harris"
    };
    
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

        if (showPatient){
          patientGeneration();
        }
        // USER PART OF THE SCREEN
        if (blnGetStartedselected){
            patientNumber();
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

    }

    public void loadPatientImages(){

        // Welcome page 
        imgWelcomePage = loadImage("/Images/WelcomePage.png");
        imgWelcomePage.resize(350, 515);

        // Insert patient number
        imgPatientNumber = loadImage("/Images/pleaseEnterPatientNumber.png");
        imgPatientNumber.resize(width, height);

    }

    public void patientNumber(){
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
        text("Patient Number: " + currentPatient, 50, 250);

        // Display the list size
        textSize(30);
        int index = Arrays.stream(patientsNum).boxed().toList().indexOf(currentPatient);
        if (index >= 0){
          text(("Nice To Meet You " + firstNames[index]+ "!"), 50, 450);
        }
        

    }

    public void patientGeneration(){
      int quantity = 20;
      Random random = new Random();
  

      
      if(reprint == 0){
        for (int i = 0; i < quantity; i++){
            patientsNum[i] = random.nextInt((i*100),((i+1) *100));
        }
        reprint+=1;
      }

      for (amount = 0; amount < quantity; amount++){
        
        fill(15, 47, 118);
<<<<<<< HEAD
        textSize(16);
        text(("First Name: "+firstNames[amount]+"\t\t Last Name: "+lastNames[amount]+"\t\t Patient Number: "+patientsNum[amount]).toString(), 500, 20*(amount));
        System.out.println(("First Name: "+ firstNames[amount]+"\t Last Name: "+lastNames[amount]+"\t Patient Number: "+patientsNum[amount]).toString());
        textSize(18);
        text(("First Name: "+firstNames[amount]+"\t\t Last Name: "+lastNames[amount]+"\t\t Patient Number: "+patientsNum[amount]).toString(), 500, 30+(28*(amount)));
        //System.out.println(("First Name: "+firstNames[amount]+"\t Last Name: "+lastNames[amount]+"\t Patient Number: "+patientsNum[amount]).toString());
=======

        textSize(18);
        text(" > ", 450, 30+(28*(amount)));
        text(("First Name: "+firstNames[amount]), 500, 30+(28*(amount)));
        text(("Last Name: "+lastNames[amount]), 750, 30+(28*(amount)));
        text(("Patient Number: "+patientsNum[amount]), 1000, 30+(28*(amount)));
        //System.out.println(("First Name: "+ firstNames[amount]+"\t Last Name: "+lastNames[amount]+"\t Patient Number: "+patientsNum[amount]).toString());
      }
    }

    public void patientInfo(int position){
      String namePatient = firstNames[position-1] + lastNames[position-1];
      for (int i =0; i<800; i++){
        fill(255,0,0);
        textSize(40);
        text(namePatient, 450, 100);
>>>>>>> 9c6d32e1cea2d8d123f3d851b7b08ffd76d04e76
      }
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

        if (checkbutton){
          if (mouseX > 450 && mouseX < 475 && mouseY > 20 && mouseY < 565){
            
            double position = 545.0/20.0;
            int number = 0;
            for(int i = 0; i < 20; i++){
              if(mouseY < 20+(i*position)){
                number = i;
                break;
              }
            }
            patientInfo(number);
            showPatient = false;
            checkbutton = false;
            
          }
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
            currentPatient = Integer.parseInt(userInput);
            userInput = ""; // Clear the input after setting the variable
          }
        }
      }
    }
    
    public void keyReleased(){}
    
    public void keyTyped(){}
}