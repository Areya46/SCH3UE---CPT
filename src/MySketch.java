import processing.core.PApplet;
import processing.core.PImage;

import java.util.*;


public class MySketch extends PApplet {


    Random myRandom = new Random();


    // General Variables
    PImage imgPhoneOutline;
    PImage imgNextButton;
    PImage imgBackButton;
    PImage imgHowToPage;
    PImage imgLogo;
    boolean blnShowNextButton;
    boolean blnShowBackButton;
    boolean blnShowHowTo;
    boolean blnInsertPatientNumber;
    boolean blnPatientEnteredNumber;
    boolean blnSymptomsPage1;
    boolean blnUpdateSymptom;
    boolean blnHeartRate;
    double position = 545.0/20.0;
    int anotherNumber;
    int heartrate = 80;
    int line0 = 45;
    int line1 = 45 + 35;
    int line2 = 45 + 65;
    int line3 = 45 + 95;
    int line4 = 45 + 125;
    int line5 = 45 + 155;
    int line6 = 45 + 185;
    int line7 = 45 + 215;
    int line8 = 45 + 245;
    int line9 = 45 + 275;
    int line10 = 45 + 305;


    int circleX0 = 45;
    int circleX1 = 45 + 35;
    int circleX2 = 45 + 65;
    int circleX3 = 45 + 95;
    int circleX4 = 45 + 125;
    int circleX5 = 45 + 155;
    int circleX6 = 45 + 185;
    int circleX7 = 45 + 215;
    int circleX8 = 45 + 245;
    int circleX9 = 45 + 275;
    int circleX10 = 45 + 305;
    int severitySymptom1 = 45 + 155;
    int severitySymptom2 = 45 + 155;
    int severitySymptom3 = 45 + 155;
    int severitySymptom4 = 45 + 155; 
    double oldSeveritySymptom1 = severitySymptom1;
    double oldSeveritySymptom2 = severitySymptom2;
    double oldSeveritySymptom3 = severitySymptom3;
    double oldSeveritySymptom4 = severitySymptom4;
    double newSeverity1;
    double newSeverity2;
    double newSeverity3;
    double newSeverity4;
    double changeInSeverity1;
    double changeInSeverity2;
    double changeInSeverity3;
    double changeInSeverity4;
    double difference1;
    double difference2;
    double difference3;
    double difference4;
    int elpasedTime;
    int startCountDown;
    boolean blnStartTIMER;
    boolean blnAddSymptom;

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
    boolean caluclating = true;
    boolean waitlistscreen = false;
    boolean moving = false;
    boolean ShowPatientInfo = false;
    String movingDirrection;
    int checkingPatientPosition;
    int[] patientsNum = new int[20];
    boolean start = true;

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


    String[][] easySymptomsList = {
      {"Throbbing headache", "Nausea", "Sensitivity to light", "Unilateral pain"}, // Migraine
      {"Sharp orbital pain", "Watery eye", "Nasal congestion", "Recurrent attacks"}, // Cluster Headache
      {"Dull, tight headache", "No nausea", "Bilateral pressure", "Mild fatigue"}, // Tension Headache
      {"Frontal headache", "Nasal congestion", "Tenderness over sinuses", "Facial pressure"}, // Sinus Headache
      {"Chest tightness during exertion", "Relieved by rest", "Short duration", "Mild discomfort"}, // Stable Angina
      {"Chest pain radiating to arm", "Sweating", "Nausea", "Prolonged duration"}, // STEMI
      {"Positional chest pain", "Relieved by leaning forward", "Fever", "Fatigue"}, // Pericarditis
      {"Localized chest pain", "Worsened with palpation", "Worsened by breathing", "Tenderness"}, // Costochondritis
      {"Sharp chest pain with breathing", "History of URI", "Mild fever", "Cough"}, // Pleuritic Pain
      {"Burning stomach pain", "Worse after eating", "Nausea", "Bloating"}, // Gastritis
      {"Severe epigastric pain", "Radiates to back", "Worsened after fatty meal", "Vomiting"}, // Pancreatitis
      {"Sharp RLQ pain", "Fever", "Difficulty moving", "Nausea"}, // Appendicitis
      {"Gnawing stomach pain", "Worse at night", "Blood in stool", "Indigestion"}, // Peptic Ulcer
      {"RUQ pain", "Shoulder pain", "Nausea after fatty meal", "Murphy's sign"}, // Cholecystitis
      {"Swollen ankle", "Sharp pain", "Difficulty walking", "Bruising"}, // Ankle Sprain
      {"Deformed wrist", "Severe pain", "Swelling after fall", "Tenderness"}, // Distal Radius Fracture
      {"Swollen calf", "Throbbing pain", "Worsened by standing", "Redness"}, // DVT
      {"Excessive thirst", "Frequent urination", "Fatigue", "High blood sugar"}, // Hyperglycemia
      {"Seizure", "Postictal confusion", "Tongue biting", "Incontinence"} // First-Time Seizure
  };
 
  int[][] symptomSeverities = {
      {8, 6, 7, 7}, // Migraine
      {9, 4, 5, 8}, // Cluster Headache
      {5, 0, 4, 3}, // Tension Headache
      {6, 7, 8, 5}, // Sinus Headache
      {6, 2, 4, 3}, // Stable Angina
      {9, 8, 7, 10}, // STEMI
      {7, 4, 5, 6}, // Pericarditis
      {6, 8, 7, 5}, // Costochondritis
      {8, 5, 4, 6}, // Pleuritic Pain
      {7, 6, 5, 4}, // Gastritis
      {9, 8, 7, 6}, // Pancreatitis
      {8, 6, 7, 5}, // Appendicitis
      {6, 5, 7, 4}, // Peptic Ulcer
      {8, 7, 6, 8}, // Cholecystitis
      {6, 7, 8, 5}, // Ankle Sprain
      {8, 9, 7, 6}, // Distal Radius Fracture
      {7, 8, 6, 5}, // DVT
      {6, 5, 7, 9}, // Hyperglycemia
      {9, 6, 8, 5}  // First-Time Seizure
  };
  
  int [] heartrates = {80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80};

  double[] AverageSeverities = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
  double[] CalculatedPainScale = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
  String[] WaitList = new String[20];
  String [] FullNames = {
    "John Smith", "Emily Johnson", "Michael Ponze", "Sophia Williams", 
    "David Jones", "Olivia Garcia", "James Miller", "Isabella Davis", 
    "Daniel Martinez", "Mia Hernandez", "Ethan Lopez", "Ava Gonzalez", 
    "Alexander Wilson", "Charlotte Anderson", "Benjamin Thomas", 
    "Amelia Taylor", "Lucas Moore", "Harper Jackson", 
    "Henry White", "Ella Harris"
};
  String [] ShowedWaitList = {
      "John Smith", "Emily Johnson", "Michael Ponze", "Sophia Williams", 
      "David Jones", "Olivia Garcia", "James Miller", "Isabella Davis", 
      "Daniel Martinez", "Mia Hernandez", "Ethan Lopez", "Ava Gonzalez", 
      "Alexander Wilson", "Charlotte Anderson", "Benjamin Thomas", 
      "Amelia Taylor", "Lucas Moore", "Harper Jackson", 
      "Henry White", "Ella Harris"
  };
  String[] Dirrection = {"","","","","","","","","","","","","","","","","","","",""};

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

         // Draw outline of phone for patient screen
         image(imgPhoneOutline, 14,5);

        if (showPatient){
          patientGeneration();
        }
        // USER PART OF THE SCREEN
        if (blnGetStartedselected && !blnPatientEnteredNumber){
          patientNumber();
        }
        if (!blnGetStartedselected){
            welcomePage();
        }
       
        if(patientscreen){
          patientInfo(number);
          drawingGraph(number);
        }

        if(waitlistscreen){
          showWaitList();
          moving = true;
          if(start){
            switchPosition(0);
            start = false;
          }
          if(ShowPatientInfo){
            CheckInfo(checkingPatientPosition);
          }
        }

        if (blnHeartRate){
          updateHeartRate(number);
        }

        if (blnShowNextButton){
          image(imgNextButton, 240,525);
        }

        if(blnSymptomsPage1){
          symptomsPage1();
        }

        if (blnPatientEnteredNumber){
          if (blnShowHowTo){
            howToPage();
          }
        }

        if (blnUpdateSymptom){
          updateSymptoms(currentPatient, number);
          blnShowNextButton = false;
        }

        if (blnAddSymptom){
          addSymptom(currentPatient);
          blnShowNextButton = false;
        }

        if (blnShowBackButton){
          image(imgBackButton, 45, 525);
        }

    }
     
    public static void main(String[] args) {
        PApplet.main("MySketch");
    }

    public void welcomePage(){
        image(imgWelcomePage, 25, 30);

    }

    public void AverageSeverityCalc() {
      // Loop through each patient (19 patients as in the provided list)
      for (int i = 0; i < categoriesList.length; i++) {
          // Calculate the average severity
          AverageSeverities[i] = (symptomSeverities[i][0] + symptomSeverities[i][1] + symptomSeverities[i][2] + symptomSeverities[i][3]) / 4.0;
  
          // Trim the string to avoid hidden spaces and compare the category correctly
          String category = categoriesList[i].trim(); // Trim any extra spaces
  
          // Set the CalculatedPainScale based on the conditions
          if (category.equals("Chest Pain")) {
              CalculatedPainScale[i] = AverageSeverities[i] + 2;
          } else if (category.equals("Head Pain")) {
              CalculatedPainScale[i] = AverageSeverities[i] + 1.5;
          } else if (category.equals("Stomach Pain")) {
              CalculatedPainScale[i] = AverageSeverities[i] + 1;
          } else if (category.equals("Limb Pain")) {
              CalculatedPainScale[i] = AverageSeverities[i] + 0.5;
          } else if (category.equals("Other")) {
              CalculatedPainScale[i] = AverageSeverities[i]; // No adjustment for "Other"
          } else {
              // For conditions that are not matched, you can leave CalculatedPainScale unchanged or handle accordingly
              CalculatedPainScale[i] = AverageSeverities[i];
          }
      }
  }  

    public void loadPatientImages(){


       // Load Picture of Phone
       imgPhoneOutline = loadImage("/Images/Phone outline.png");
       imgPhoneOutline.resize(width/3 - 5, 575);


       // Welcome page
       imgWelcomePage = loadImage("/Images/WelcomePage.png");
       imgWelcomePage.resize(345, 550);

       // Insert patient number
       imgPatientNumber = loadImage("/Images/pleaseEnterPatientNumber.png");
       imgPatientNumber.resize(width, height);


       // Next Button
       imgNextButton = loadImage("/Images/Next Button.png");
       imgNextButton.resize(300, 500);


       // Back and Next button
       imgBackButton = loadImage("Images/backButton.png");
       imgBackButton.resize(300, 500);


       // How to page text
       imgHowToPage = loadImage("Images/HowToPage.png");
       imgHowToPage.resize(340, 550);

    }

    public void patientNumber(){
        // Text saying to enter patient number below


        image(imgPatientNumber, 10, 20);
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
          blnPatientEnteredNumber = true;
          text(("Nice to meet you"), 50, 450);
          text((firstNames[index] + "!"), 50, 480);
          blnShowNextButton = true;
          blnShowHowTo = true;
        }
       
        blnShowNextButton = true;
        blnShowHowTo = true;

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

      AverageSeverityCalc();
      WaitingList();

      fill(15, 47, 118);
      textSize(18);
      text("Wait List", 1170 , 585);
    }

    public void howToPage(){
      // Display the list size
      textSize(16);

      // Display the list size
      textSize(30);
      int index = Arrays.stream(patientsNum).boxed().toList().indexOf(currentPatient);
      if (index >= 0){
        blnPatientEnteredNumber = true;
        text(("Nice to meet you"), 50, 75);
        text((firstNames[index] + "!"), 50, 105);
        blnShowNextButton = true;
        blnShowHowTo = true;
      }

      //image(imgHowToPage, 30, 120);
      fill(13, 60, 117);
      textSize(20);
      text("Welcome to Life LinkER!", 45, 60 + 90);
      text("Your fast and efficient way to ", 45, 90 + 90);
      text("keep your healthcare providers ", 45, 120 + 90);
      text("updated. You will be asked to", 45, 150 + 90);
      text("rate the intensity of what you ", 45, 180 + 90);
      text("are experiencing on a scale", 45, 210 + 90);
      text("from 0 to 10 and enter in any", 45, 240 + 90);
      text("other infromation that is ", 45, 270 + 90);
      text("applicable to your situation, ", 45, 300 + 90);
      text("including your heart rate if you", 45, 330 + 90);
      text("have a device that measures it", 45, 360 + 90);
      text("(for instance; an apple watch or", 45, 390 + 90);
      text("fit bit).", 45, 390 + 120);

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
      text("Likely Condition: ", 450 , 155);


      fill(71, 87, 128);
      textSize(20);
      text(conditionsList[position-1],660, 155);


      fill(39, 60, 115);
      textSize(25);
      text("Observed Symptoms: ", 450, 200);


      fill(71, 87, 128);
      textSize(18);
      text(symptomsList[position-1],450, 230);


      fill(39, 60, 115);
      textSize(25);
      text("Patient Reported Symptoms: ", 450, 375);


      for (int i = 0; i < easySymptomsList[position-1].length; i++){
        fill(71, 87, 128);
        textSize(18);
        text((easySymptomsList[position-1][i] +"     \t\t"+ symptomSeverities[position-1][i]),450, 400+(20*i));
      }

      fill(39, 60, 115);
      textSize(25);
      text("Average Severity:  ", 450, 480 + 15);
      text(String.format("%.1f", AverageSeverities[position - 1]),650 + 10, 480 + 15);

      text("Current Heart Rate: " + heartrates[position -1], 450, 480 + 45);

    }

    public void drawingGraph(int position){
      //vertical
      line(900, 300, 900, 500);
      //horizonal
      line(900, 500, 1180, 500);
      
      for(int i = 0; i <4; i++){

        fill(255, 255, 255); // Set fill color to white
        float rectWidth = 280 * ((float)symptomSeverities[position-1][i] / 10); // Cast to float
        rect(900, 300 + (50 * i), rectWidth, 50); // Draw rectangle

        fill(39, 60, 115);
        textSize(10);
        text(easySymptomsList[position-1][i], 910, 325 + (50 * i));
      }

    }

    public void WaitingList() {
      // Assuming the arrays are already defined and populated
      // firstNames, CalculatedPainScale, WaitList are all arrays of length 3 (or 20 in your case)
  
      // Create an array of indices to represent the position of elements in the original array
      int[] indices = new int[firstNames.length];
  
      // Initialize the indices array to the default order (0, 1, 2, ...)
      for (int i = 0; i < firstNames.length; i++) {
          indices[i] = i;
      }
  
      // Sort the indices array based on the values in CalculatedPainScale (descending order)
      for (int i = 0; i < indices.length - 1; i++) {
          for (int j = i + 1; j < indices.length; j++) {
              if (CalculatedPainScale[indices[j]] > CalculatedPainScale[indices[i]]) {
                  // Swap the indices to reorder them by descending pain scale
                  int temp = indices[i];
                  indices[i] = indices[j];
                  indices[j] = temp;
              }
          }
      }
  

      // Populate the WaitList with names from firstNames, sorted by CalculatedPainScale
      for (int i = 0; i < firstNames.length; i++) {
          WaitList[i] = firstNames[indices[i]] +" "+ lastNames[indices[i]];  // Assign names to WaitList based on sorted indices
      }
  }
  
    public void showWaitList() {
    fill(71, 87, 128);
    textSize(35);
    text("Waiting List", 450, 50);
    fill(13, 60, 117);
    textSize(40);
    text("<", 1150, 50);

    for (int i = 0; i <= 19; i++) {
        // Direction indicators
        if (Dirrection[i].equals("Up")) {
            fill(13, 110, 42);
            textSize(25);
            text("^", 700, (80 + (25 * i)) + 5);
            fill(13, 60, 117);
            textSize(20);
            text("v", 715, (80 + (25 * i)) - 1);
        } else if (Dirrection[i].equals("Down")) {
            fill(110, 13, 13);
            textSize(20);
            text("v", 700, 80 + (25 * i));
            fill(13, 60, 117);
            textSize(25);
            text("^", 715, (80 + (25 * i)) + 7);
        } else {
            fill(158, 131, 55);
            textSize(30);
            text("-", 700, 80 + (25 * i));
            Dirrection[i] = "";
        }

        // Display patient information
        fill(71, 87, 128);
        textSize(19);
        text(((i + 1) + ": " + ShowedWaitList[i]), 450, 80 + (25 * i));
        text(">", 770, 80 + (25 * i));

        // Check average severity and draw star if needed
        if (AverageSeverities[i] == 10) { // Assuming alignment of `AverageSeverities` and `ShowedWaitList`
            fill(252, 165, 3); // Orange color for the star
            textSize(50);
            text("*", width/2, 100 + (25 * i)); // Adjust x position if needed
        }
    }
}
  
    public void switchPosition(int position){
      System.out.println("Button Clicked for: "+ShowedWaitList[position]);
      if ((Dirrection[position]).equals("Up") ){
        String placeHolder = ShowedWaitList[position];
        ShowedWaitList[position] = ShowedWaitList[position-1];
        ShowedWaitList[position-1] = placeHolder;
      }
      else if ((Dirrection[position]).equals("Down") ){
        String placeHolder = ShowedWaitList[position];
        ShowedWaitList[position] = ShowedWaitList[position+1];
        ShowedWaitList[position+1] = placeHolder;
      }
            // Recalculate directions for all entries
      for (int i = 0; i < ShowedWaitList.length; i++) {
        int indexInWaitList = Arrays.asList(WaitList).indexOf(ShowedWaitList[i]);

        if (indexInWaitList < i) {
          Dirrection[i] = "Up";
        } else if (indexInWaitList > i) {
          Dirrection[i] = "Down";
        } else {
          Dirrection[i] = "";
        }
      }
      showWaitList();
    }
   
    public void CheckInfo(int position){
      int InfoIndex = Arrays.asList(FullNames).indexOf(ShowedWaitList[position]);
      text(("Severity: "+AverageSeverities[InfoIndex] +"        Category: "+ categoriesList[InfoIndex]), 800, 80+(25*position));
    }   

    public void addSymptom(int patientNumber){

    blnShowBackButton = true;
    
    int index = Arrays.stream(patientsNum).boxed().toList().indexOf(patientNumber);
    if (index >= 0){
      fill(39, 60, 115);
      textSize(20);
      text("Which of the following best", 40, 85);
      text("described the another reason why", 40, 105);
      text("you are here to see an emergency", 40, 125);
      text("room doctor: ", 40, 145);

      fill(71, 87, 128);
      textSize(18);

      fill(71, 87, 128);
      textSize(18);
      text("> Bleeding", 40, 175);
      text("> Chest pain/Chest related issues", 40, 205);
      text("> Feel light headed", 40, 240);
      text("> Abrupt loss of strength in limbs", 40, 275);
      text("> Sudden difficulty with speech", 40, 310);
      text("> Are in/are entering labour", 40, 345);
      text("> Shortness of breath", 40, 380);
      text("> Developed an itchiness/rash", 40, 415);
      text("> Other", 40, 450);
    }
  }

    public void updateHeartRate(int position){

    blnShowBackButton = true;

    fill(13, 60, 117);
    textSize(20);
    text("Please enter your heart rate below; ", 40, 100);
    text("Heart Rate: ", 40 ,130);
    textSize(40);
    text("^", 90, 175);
    text(heartrates[position - 1] + " BPM", 120, 175);
    text("v", 210 + 80, 170);

    if (heartrates[position - 1] <= 60 || heartrates[position - 1] >= 100){
      textSize(25);
      text("IF YOU ARE ABLE TO",  40, 240);
      text("PLEASE SEE THE NURSE", 40, 270);
      text("AT THE NURSES STATION", 40,300);
      text("NOW AND SHOW HER THIS", 40, 330);
      text("MESSAGE", 40, 360);

      // Update the average patient severity
      int currentPatientNum = -1; // Default value if not found
      for (int i = 0; i < patientsNum.length; i++) {
      if (patientsNum[i] == currentPatient) {
        currentPatientNum = i;
        break;
      }
      }
      // ADD THREE TO AVERAGE SEVERITY
      if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
        AverageSeverities[currentPatientNum] = 10;
      }  

    }

    textSize(15);
    text("(Please enter the data based on the reading ", 40, 400);
    text("on your smartwatch or other BPM reading", 40, 420);
    text("device)", 40, 440);
  }

    public void symptomsPage1(){
      blnShowNextButton = false;
      blnShowBackButton = false;

      fill(13, 60, 117);
      textSize(30);
      text("Symptom Tracker", 40 + 30 ,70);


      // First heading
      fill(13,60, 117);
      textSize(40);
      text(">", 45, 110);


      fill(13, 60, 117);
      textSize(20);
      text("Pre-existing Symptomes", 75, 108);


      // Second Heading
      fill(13,60, 117);
      textSize(40);
      text(">", 45, 110 + 60);


      fill(13, 60, 117);
      textSize(20);
      text("New symptom", 75, 168);  

      // Third heading 
      fill(13,60, 117);
      textSize(40);
      text(">", 45, 220);


      fill(13, 60, 117);
      textSize(20);
      text("Heart rate tracker", 75, 220);  
   
    }

    public void updateSymptoms(int patientNumber, int position) {  
      
      blnShowBackButton = true;

      int index = Arrays.stream(patientsNum).boxed().toList().indexOf(patientNumber);
      
      if (index >= 0) {

          fill(39, 60, 115);
          textSize(25);
          text("Symptoms: ", 40, 110);

          fill(71, 87, 128);
          textSize(18);
          int yvalue = 140;

          for (String symptom : easySymptomsList[index]) {
              text("- " + symptom, 45, yvalue);
              yvalue += 80;
          }

      } else {
          text("Patient number not found.", 450, 60);
      }

      
      for (int i = 0; i < 4; i++){
        fill(71, 87, 128);
        textSize(25);
        text("^ " + (symptomSeverities[position -1][i]),145, 185+(80*i));
        text(" v",195, 180+(80*i));
      }  

  }

    public void mouseClicked(){

      // Altering the severity of symptom 1
      if (blnUpdateSymptom && mouseX >= 135 && mouseX <= 160 && mouseY >= 165 && mouseY <= 185){
        
      }
      else if (blnUpdateSymptom && mouseX >= 185 && mouseX <= 215 && mouseY >= 165 && mouseY <= 185){
        // Add code to update severity 
        System.out.println("Hit");
      }
      // Altering the severity of symptom 2
      if (blnUpdateSymptom && mouseX >= 135 && mouseX <= 160 && mouseY >= 245 && mouseY <= 265){
        
      }
      else if (blnUpdateSymptom && mouseX >= 185 && mouseX <= 215 && mouseY >= 245 && mouseY <= 265){
         
      }
      // Altering the severity of symptom 3
      if (blnUpdateSymptom && mouseX >= 135 && mouseX <= 160 && mouseY >= 325 && mouseY <= 345){
        
      }
      else if (blnUpdateSymptom && mouseX >= 185 && mouseX <= 215 && mouseY >= 325 && mouseY <= 345){
         
      }
      // Altering the severity of symptom 4
      if (blnUpdateSymptom && mouseX >= 135 && mouseX <= 160 && mouseY >= 405 && mouseY <= 425){
        
      }
      else if (blnUpdateSymptom && mouseX >= 185 && mouseX <= 215 && mouseY >= 405 && mouseY <= 425){
        // Add code to update severity 
        System.out.println("Hit");
      }

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


        if (checkbutton) {
          if (mouseX > 450 && mouseX < 475 && mouseY > 20 && mouseY < 565) {
              for (int i = 0; i < 20; i++) {
                  if (mouseY < 20 + (i * position)) {
                      number = i; // Number tracks the patient being clicked
                      break;
                  }
              }
              // Perform actions for the selected patient
              showPatient = false;
              checkbutton = false;
              patientscreen = true;
          }
      }      

        if (mouseX >= 1150 && mouseX <= 1300 && mouseY >= 550 && mouseY <= 600){
          showPatient = false;
          checkbutton = false;
          patientscreen = false;
          waitlistscreen = true;
        }

        if (waitlistscreen){
          if (mouseX > 1100 && mouseX < 1200 && mouseY > 20 && mouseY < 60) {
            patientscreen = false;
            waitlistscreen = false;
            showPatient = true;
            checkbutton = true;
          }
          if (mouseX > (width/3) && mouseX < 785) {
            ShowPatientInfo = true;
          }
        }
        else{
          ShowPatientInfo = false;
        }

        if(ShowPatientInfo){
          for (int i = 0; i <= 19; i++) {
            // Check if mouseY is within the range of the current button
            if (mouseY > (80 + 25 * i) - 10 && mouseY < (80 + 25 * i) + 10) {
              checkingPatientPosition = i;
            }
          }
        }

        if (moving) {
          if (mouseX > width/3 && mouseX < 715) {
            for (int i = 0; i <= 19; i++) {
              // Check if mouseY is within the range of the current button
              if (mouseY > (80 + 25 * i) - 10 && mouseY < (80 + 25 * i) + 10) {
                switchPosition(i);
                break; // Exit loop after finding the matching button
              }
            }
          }
          if (mouseX > 715 && mouseX < 740) {
            for (int i = 0; i <= 19; i++) {
              // Check if mouseY is within the range of the current button
              if (mouseY > (80 + 25 * i) - 10 && mouseY < (80 + 25 * i) + 10) {
                if(Dirrection[i].equals("Up")){
                  Dirrection[i] = "Down";
                }
                else if(Dirrection[i].equals("Down")){
                  Dirrection[i] = "Up";
                }
                switchPosition(i);
                break; // Exit loop after finding the matching button
              }
            }
          }
        }
        
        // Was next selcted?
        if (mouseX >= 240 && mouseX <= (240 + 125) && mouseY >= 525 && mouseY <= (525 + 30)){
          if (blnShowHowTo){
            blnSymptomsPage1 = true;
            blnShowHowTo = false;
            System.out.println("oH yayayayy");
          }
        }

        // Was back selected?
        if (mouseX >= 45 && mouseX <= (45 + 125) && mouseY >= 525 && mouseY <= (525 + 30)){
          if (blnUpdateSymptom){
            blnSymptomsPage1 = true;
            blnUpdateSymptom = false;
            System.out.println("blnSymptomsPage1 =" + blnSymptomsPage1);
            System.out.println("blnUpdateSymptom = " + blnUpdateSymptom);
          }
          if (blnAddSymptom){
            blnSymptomsPage1 = true;
            blnAddSymptom = false;
          }
          if (blnHeartRate){
            blnSymptomsPage1 = true;
            blnHeartRate = false;
          }
        }
        // Do they want to alter a pre-existing symtom?
        if (blnSymptomsPage1 && mouseX >= 35 && mouseX <= (width/3 - 100) && mouseY >= 90 && mouseY <= 90 + 35 ){
          System.out.println("THEY WANT TO UPDATE");
          blnSymptomsPage1 = false;
          blnUpdateSymptom = true;
        }

        // Do they want to update a symptom?
        if (blnSymptomsPage1 && mouseX >= 35 && mouseX <= (width/3 - 175) && mouseY >= 148 && mouseY <= 148 + 35){
          System.out.println("They ARE FEELING SOMTHING ELSE");
          blnAddSymptom = true;
          blnSymptomsPage1 = false;
        }

        // They are entering the screen regarding the heart rate 
        if (blnSymptomsPage1 && mouseX >= 35 && mouseX <= (width/3 - 175) && mouseY >= 200 && mouseY <= 200 + 35){
          System.out.println("Update heart rate");
          blnSymptomsPage1 = false;
          blnHeartRate = true;
        }

        if (blnHeartRate && mouseX >= 90 && mouseX <= 130 && mouseY >= 145 && mouseY <= 185){
          heartrates[(int)number -1] += 1;
        }
        if (blnHeartRate && mouseX >= 205 + 80 && mouseX <= 235 + 80 && mouseY >= 145 && mouseY <= 185){
          heartrates[(int)number -1] -= 1;
        }

        // They are bleeding
        if (blnAddSymptom && mouseX >= 40 && mouseX <= (width/3 - 175) && mouseY <= 175 && mouseY >= 155){
          System.out.println("they are bleeding");
          int currentPatientNum = -1; // Default value if not found
          for (int i = 0; i < patientsNum.length; i++) {
            
              if (patientsNum[i] == currentPatient) {
                  currentPatientNum = i;
                  break;
              }
          }
          // ADD TWO TO AVERAGE SEVERITY
          if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
            if (AverageSeverities[currentPatientNum] <= 10) {
                AverageSeverities[currentPatientNum] += 2;
                System.out.println("I added 2");
            }
            if (AverageSeverities[currentPatientNum] > 10){
              AverageSeverities[currentPatientNum] = 10;
            }
          }           
        }

        // They have chest pain 
        if (blnAddSymptom && mouseX >= 40 && mouseX <= (width/3 - 175) && mouseY <= 205 && mouseY >= 185){
          System.out.println("they have chest pain");
          
          int currentPatientNum = -1; // Default value if not found
          for (int i = 0; i < patientsNum.length; i++) {
            
              if (patientsNum[i] == currentPatient) {
                  currentPatientNum = i;
                  break;
              }
          }
          // ADD THREE TO AVERAGE SEVERITY
          if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
            if (AverageSeverities[currentPatientNum] <= 10) {
                AverageSeverities[currentPatientNum] += 3;
                System.out.println("I added 3");
            }
            if (AverageSeverities[currentPatientNum] > 10){
              AverageSeverities[currentPatientNum] = 10;
            }
          }           
        }

        // They feel light headed 
        if (blnAddSymptom && mouseX >= 40 && mouseX <= (width/3 - 175) && mouseY <= 240 && mouseY >= 220){
          System.out.println("they are feeling light headed");
          // ADD 1 TO AVERGAE SEVERITY
          int currentPatientNum = -1; // Default value if not found
          for (int i = 0; i < patientsNum.length; i++) {
            
              if (patientsNum[i] == currentPatient) {
                  currentPatientNum = i;
                  break;
              }
          }
          // ADD ONE TO AVERAGE SEVERITY
          if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
            if (AverageSeverities[currentPatientNum] <= 10) {
                AverageSeverities[currentPatientNum] += 1;
                System.out.println("I added 1");
            }
            if (AverageSeverities[currentPatientNum] > 10){
              AverageSeverities[currentPatientNum] = 10;
            }
          }           
        }

        // They feel a loss of strength in their limbs 
        if (blnAddSymptom && mouseX >= 40 && mouseX <= (width/3 - 175) && mouseY <= 275 && mouseY >= 255){
          System.out.println("Abrupt loss of strength in limbs");
          int currentPatientNum = -1; // Default value if not found
          for (int i = 0; i < patientsNum.length; i++) {
            
              if (patientsNum[i] == currentPatient) {
                  currentPatientNum = i;
                  break;
              }
          }
          // ADD THREE TO AVERAGE SEVERITY
          if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
            if (AverageSeverities[currentPatientNum] <= 10) {
                AverageSeverities[currentPatientNum] += 3;
                System.out.println("I added 3");
            }
            if (AverageSeverities[currentPatientNum] > 10){
              AverageSeverities[currentPatientNum] = 10;
            }
          }           
        }

        // Sudden difficulty with speech 
        if (blnAddSymptom && mouseX >= 40 && mouseX <= (width/3 - 175) && mouseY <= 310 && mouseY >= 290){
          System.out.println("Sudden difficulty with speech");
          // ADD THREE TO AVERAGE SEVERITY 
          int currentPatientNum = -1; // Default value if not found
          for (int i = 0; i < patientsNum.length; i++) {
            
              if (patientsNum[i] == currentPatient) {
                  currentPatientNum = i;
                  break;
              }
          }
          if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
            if (AverageSeverities[currentPatientNum] <= 10) {
                AverageSeverities[currentPatientNum] += 3;
                System.out.println("I added 3");
            }
            if (AverageSeverities[currentPatientNum] > 10){
              AverageSeverities[currentPatientNum] = 10;
            }
          }           
        }

        // Are in/entering labour 
        if (blnAddSymptom && mouseX >= 40 && mouseX <= (width/3 - 175) && mouseY <= 345 && mouseY >= 325){
          System.out.println("Are in/entering labour");  
          // MOVE THEM TO THE TOP OF THE PRIOTITY LIST 
          int currentPatientNum = -1; // Default value if not found
          for (int i = 0; i < patientsNum.length; i++) {
            
              if (patientsNum[i] == currentPatient) {
                  currentPatientNum = i;
                  break;
              }
          }
          if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
              AverageSeverities[currentPatientNum] = 10;
              System.out.println("I added 10");
          }
        }

        // They are experiencing a shortness of breath 
        if (blnAddSymptom && mouseX >= 40 && mouseX <= (width/3 - 175) && mouseY <= 380 && mouseY >= 360){
          System.out.println("They are experiencing a shortness of breath");
          // MOVE TO THE TOP OF THE LIST
          int currentPatientNum = -1; // Default value if not found
          for (int i = 0; i < patientsNum.length; i++) {
            
              if (patientsNum[i] == currentPatient) {
                  currentPatientNum = i;
                  break;
              }
          }
          if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
              AverageSeverities[currentPatientNum] = 10;
          }
        }

        // They are developing an rash/are itchy
        if (blnAddSymptom && mouseX >= 40 && mouseX <= (width/3 - 175) && mouseY <= 415 && mouseY >= 395){
          System.out.println("Developed an itchiness/rash");
          // ADD 1 TO THE AVERAGE SEVERITY 
          int currentPatientNum = -1; // Default value if not found
          for (int i = 0; i < patientsNum.length; i++) {
            
              if (patientsNum[i] == currentPatient) {
                  currentPatientNum = i;
                  break;
              }
          }
          if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
            if (AverageSeverities[currentPatientNum] <= 10) {
                AverageSeverities[currentPatientNum] += 1;
                System.out.println("I added 1");
            }
            if (AverageSeverities[currentPatientNum] > 10){
              AverageSeverities[currentPatientNum] = 10;
            }
          } 
          
        }
        
        // They have "other" symptomes
        if (blnAddSymptom && mouseX >= 40 && mouseX <= (width/3 - 175) && mouseY <= 450 && mouseY >= 430){
          System.out.println("Other");
          // ADD 1 TO THE AVERGAE SEVERITY
          int currentPatientNum = -1; // Default value if not found
          for (int i = 0; i < patientsNum.length; i++) {
            
              if (patientsNum[i] == currentPatient) {
                  currentPatientNum = i;
                  break;
              }
          }
          if (currentPatientNum >= 0 && currentPatientNum < (AverageSeverities.length)) {
            if (AverageSeverities[currentPatientNum] <= 10) {
                AverageSeverities[currentPatientNum] += 3;
                System.out.println("I added 1");
            }
            if (AverageSeverities[currentPatientNum] > 10){
              AverageSeverities[currentPatientNum] = 10;
            }
          }  
        }

   }

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
}