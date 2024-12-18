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
    int number;
    boolean showname = true;
    boolean checkbutton = true;
    boolean showPatient = true;
    boolean patientscreen = false;
    int[] patientsNum = new int[20];
    String[] firstNames = {
        "John", "Emily", "Michael", "Sophia", "David", "Olivia", 
        "James", "Isabella", "Daniel", "Mia", "Ethan", "Ava", 
        "Alexander", "Charlotte", "Benjamin", "Amelia", "Lucas", 
        "Harper", "Henry", "Ella"
    };

    String[] lastNames = {
        "Smith", "Johnson", "Ponze", "Williams", "Jones", "Garcia", 
        "Miller", "Davis", "Martinez", "Hernandez", "Lopez", "Gonzalez", 
        "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", 
        "White", "Harris"
    };
    

        // Symptom details for each patient
    String[] symptomsList = {
      "Severe, unilateral cephalalgia for 12 hours\nPulsating quality localized to the left temporal region\nAssociated with photophobia and nausea\nMild distress noted during examination\nBlood pressure elevated at 148/92",
      "Severe unilateral orbital pain, reported as 'stabbing'\nEpisodic attacks lasting 1–2 hours, recurring for 3 days\nIpsilateral lacrimation and nasal congestion on the right side",
      "Persistent, bilateral frontal-occipital cephalalgia\nDescribed as 'tightness' or 'pressure' sensation\nNo associated nausea or visual disturbances\nReports recent stress and inadequate sleep",
      "Dull, constant frontal headache for 3 days\nPain worsens with bending forward or sudden head movements\nCongestion and purulent nasal discharge\nTenderness over the frontal and maxillary sinuses",
      "Squeezing retrosternal chest discomfort during exertion\nPain relieved with rest; lasting ~5 minutes\nBlood pressure mildly elevated at 140/88\nECG shows slight ST-segment depression",
      "Intense retrosternal chest pain radiating to left arm\nPersistent for 30 minutes, unrelieved by rest\nAssociated diaphoresis and nausea\nECG shows ST-elevation; troponin elevated",
      "Sharp, retrosternal chest pain, worsens with inspiration and lying flat\nPain improves when leaning forward\nMild fever at 100.5°F\nPericardial friction rub noted on auscultation",
      "Sharp, localized chest pain exacerbated by palpation\nPain worsened with deep inspiration and movement\nLocalized tenderness over the costosternal joint",
      "Acute, sharp chest pain exacerbated by deep breathing or coughing\nRecent history of URI\nChest X-ray indicates mild pleural effusion",
      "Burning epigastric pain, worse after eating\nReports nausea and bloating\nHistory of consuming spicy foods\nAbdominal exam shows mild tenderness",
      "Severe, constant epigastric pain radiating to the back\nWorsened after high-fat meal consumption\nAssociated nausea and vomiting\nElevated lipase and amylase levels",
      "Acute periumbilical pain migrating to RLQ\nFever of 101°F\nPositive McBurney's point tenderness and rebound pain\nElevated WBC count",
      "Gnawing epigastric pain, worse at night\nReports intermittent nausea\nHistory of NSAID use\nPositive stool occult blood test",
      "Acute RUQ abdominal pain radiating to the right shoulder\nReports nausea and vomiting after consuming fatty meals\nPositive Murphy's sign\nLow-grade fever at 100.2°F",
      "Swelling and ecchymosis around lateral malleolus\nSharp pain exacerbated by weight-bearing\nPositive anterior drawer test\nNo fractures on X-ray",
      "Severe wrist pain following fall on outstretched hand\nVisible deformity and swelling\nX-ray confirms distal radius fracture",
      "Unilateral swelling and pain in the left calf for 2 days\nPain described as 'throbbing' and worsened with standing or walking\nCalf tenderness and erythema noted",
      "Reports polyuria, polydipsia, and fatigue for 2 days\nBlurred vision and headache noted\nDry mucous membranes; patient appears dehydrated\nCapillary blood glucose elevated at 430 mg/dL",
      "Witnessed tonic-clonic seizure lasting 2 minutes\nPostictal confusion and drowsiness reported\nPatient experienced tongue biting and urinary incontinence"
    };

    // General categories for each patient
    String[] categoriesList = {
      "Head Pain", // Patient 1
      "Head Pain", // Patient 2
      "Head Pain", // Patient 3
      "Head Pain", // Patient 15
      "Chest Pain", // Patient 4
      "Chest Pain", // Patient 5
      "Chest Pain", // Patient 16
      "Chest Pain", // Patient 6
      "Chest Pain", // Patient 7
      "Stomach Pain", // Patient 8
      "Stomach Pain", // Patient 10
      "Stomach Pain", // Patient 9
      "Stomach Pain", // Patient 11
      "Stomach Pain", // Patient 17
      "Limb Pain", // Patient 13
      "Limb Pain", // Patient 14
      "Limb Pain", // Patient 18
      "Other", // Patient 19 (Hyperglycemia)
      "Other"  // Patient 20 (Seizure)
    };

    // Likely conditions for each patient
    String[] conditionsList = {
      "Migraine", // Patient 1
      "Cluster Headache", // Patient 2
      "Tension Headache", // Patient 3
      "Sinus Headache", // Patient 15
      "Stable Angina", // Patient 4
      "STEMI", // Patient 5
      "Pericarditis", // Patient 16
      "Costochondritis", // Patient 6
      "Pleuritic Pain", // Patient 7
      "Gastritis", // Patient 8
      "Pancreatitis", // Patient 10
      "Appendicitis", // Patient 9
      "Peptic Ulcer", // Patient 11
      "Cholecystitis", // Patient 17
      "Ankle Sprain", // Patient 13
      "Distal Radius Fracture", // Patient 14
      "Deep Vein Thrombosis (DVT)", // Patient 18
      "Hyperglycemia (Diabetic Crisis)", // Patient 19
      "First-Time Seizure" // Patient 20
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
        
        if(patientscreen){
          patientInfo(number);
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

        textSize(18);
        text(" > ", 450, 30+(28*(amount)));
        text(("First Name: "+firstNames[amount]), 500, 30+(28*(amount)));
        text(("Last Name: "+lastNames[amount]), 750, 30+(28*(amount)));
        text(("Patient Number: "+patientsNum[amount]), 1000, 30+(28*(amount)));
        //System.out.println(("First Name: "+ firstNames[amount]+"\t Last Name: "+lastNames[amount]+"\t Patient Number: "+patientsNum[amount]).toString());
      }
    }

    public void patientInfo(int position){
      String namePatient = firstNames[position-1] +" "+ lastNames[position-1];
      fill(13, 60, 117);
      textSize(40);
      text(namePatient, 450, 60);

      fill(13, 60, 117);
      textSize(40);
      text("<", 1150, 50);

      fill(39, 60, 115);
      textSize(25);
      text("Category: ", 450, 110);

      fill(71, 87, 128);
      textSize(20);
      text(categoriesList[position-1],650, 110);

      fill(39, 60, 115);
      textSize(25);
      text("Likely Condition: ", 450, 155);

      fill(71, 87, 128);
      textSize(20);
      text(conditionsList[position-1],650, 155);

      fill(39, 60, 115);
      textSize(25);
      text("Symptoms: ", 450, 300);

      fill(71, 87, 128);
      textSize(18);
      text(symptomsList[position-1],650, 330);



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

        if (patientscreen){
          if (mouseX > 1100 && mouseX < 1200 && mouseY > 20 && mouseY < 60) {
            patientscreen = false;
            showPatient = true;
            checkbutton = true;
          }
        }

        if (checkbutton){
          if (mouseX > 450 && mouseX < 475 && mouseY > 20 && mouseY < 565){
            
            double position = 545.0/20.0;
            for(int i = 0; i < 20; i++){
              if(mouseY < 20+(i*position)){
                number = i;
                break;
              }
            }
            
            showPatient = false;
            checkbutton = false;
            patientscreen = true;

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