import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

public class Refrences extends PApplet {
	
  // Random myRandom = new Random();

  // // Import images
  // PImage imgExterior; 

  // // Ingredient variables 
  // int xPizzaValue = 320;
  // int currentIngredientIndex = 0;
  // boolean movePizzaRight = false;
  // boolean movePizzaLeft = false;
  // float[] xValueOfFruits = new float[8];
  // float[] yValueOfFruits = new float[8];
  // float [] speedOfFruits = new float[8];
  // float[] fruitinCabinateX = new float[8];
  // float[] fruitinCabinateY = new float[8];

  // // Which customer was picked?
  // boolean Character1picked = false;
  // boolean Character2picked = false;
  // boolean Character3picked = false;

  // // Order Variables
  // float[] order1 = {9, 9, 9, 9};
  // float[] order2 = {9, 9, 9, 9};
  // float[] order3 = {9, 9, 9, 9};
  // int num1;
  // int num2;
  // int num3;

  // // Which screen is being shown?
  // boolean dipslayKitchen = false;

  // // Level Variables
  // boolean level1 = false;
  // boolean level2 = false;
  // boolean level3 = false;

  // // Lives variables 
  // int numberOfLives = 5;
  // PImage[] drawHearts = new PImage[5];

  // // Star varibale
  // boolean drawStars;
  // float timeSinceStars = 0;
  
  // // Timer variables
  // int rectLength = 120;
  // int startCountDown = -1;
  // int startTimer1;
  // boolean countdownStarted = false;
  // boolean countdownFinished = false;

  // // Lose Screen Variables
  // boolean outOfTime = false;
  // boolean gameWon = false;

  // // Math variables
  // boolean mathAnswered = false;
  // String userMathInput = "";
  // int checkMarkStartTime = 0;
  // int checkMarkDuration = 200;
  // boolean showCheckMark = false;
  // boolean showX = false;
  // int xStartTime = 2000;
  // boolean checkMath = false;
  // int answer = 0;

  // // Tutoiral variable
  // int tutorialPage = 0;
  // boolean showTutorial = false;
  // boolean characterSelected = false;
  // boolean onMiniKitchen = false;
  // boolean displayTakeOrder = false;
  // boolean displayWelcomeScreen = true;
  // int pauseScreenStartTime = 0;
  // boolean miniCollision = false;
  // int elpasedTime = 0;
  // boolean showRemember = false;
  // boolean showMiniTakeOrder = false;
  // boolean ongoingtutorial = false;
  // boolean showMiniYouWin = false;
	
  // /**
  //  * Called once at the beginning of execution, put your size all in this method
  //  */
  // public void settings() {
	// // put your size call here
  //   size(850, 500);
  // }

  // /** 
  //  * Called once at the beginning of execution.
  //  * Initalizes preset values
  //  */
  // public void setup() {

  //   // Set background colour
  //   background(0);

  //   // Load Images 
  //   loadImages();
  //   loadIngredients();
  //   loadGalleryImages();

  //   // Determine the x-values for all of the falling fruits
  //   for (int i = 0; i < xValueOfFruits.length; i++){
  //     xValueOfFruits[i] = random(width);
  //   }

  //   // Determine the speed at which each fruit will fall
  //   for (int i = 0; i < speedOfFruits.length; i++){
  //     speedOfFruits[i] = (float)random(5);
  //   }
    
  //   // Set the x values of fruit in the take out order method
  //   fruitinCabinateX[0] = 290;
  //   fruitinCabinateX[1] = 370;
  //   fruitinCabinateX[2] = 290;
  //   fruitinCabinateX[3] = 370;
  //   fruitinCabinateX[4] = 520;
  //   fruitinCabinateX[5] = 600;
  //   fruitinCabinateX[6] = 520;
  //   fruitinCabinateX[7] = 600;

  //   // Set the y values of fruit in the take out order method 
  //   fruitinCabinateY[0] = 360;
  //   fruitinCabinateY[1] = 360;
  //   fruitinCabinateY[2] = 435;
  //   fruitinCabinateY[3] = 435;
  //   fruitinCabinateY[4] = 360;
  //   fruitinCabinateY[5] = 360;
  //   fruitinCabinateY[6] = 435;
  //   fruitinCabinateY[7] = 435;
    
  //   // Randomize the first order
  //   float randomNumber1 = 0;
  //   for (int i = 0; i < order1.length; i++){
  //       while (true){
  //         randomNumber1 = myRandom.nextInt(8);
  //         if (!isInThe1stArray(randomNumber1)){
  //           break;
  //         }
  //       }
  //       order1[i] = randomNumber1;
  //   }

  //   // Randomize the second order
  //   float randomNumber2 = 0;
  //   for (int i = 0; i < order2.length; i++){
  //       while (true){
  //         randomNumber2 = myRandom.nextInt(8);
  //         if (!isInThe2ndArray(randomNumber2)){
  //           break;
  //         }
  //       }
  //       order2[i] = randomNumber2;
  //   }

  //   // Randomize the second order
  //   float randomNumber3 = 0;
  //   for (int i = 0; i < order3.length; i++){
  //       while (true){
  //         randomNumber3 = myRandom.nextInt(8);
  //         if (!isInThe3rdArray(randomNumber3)){
  //           break;
  //         }
  //       }
  //       order3[i] = randomNumber3;
  //   }    

  //   // Set randomized numbers for math euqation
  //   num1 = myRandom.nextInt(5);
  //   num2 = myRandom.nextInt(6);
  //   num3 = myRandom.nextInt(3);

  // }

  // /**
  //  * Called repeatedly, anything drawn to the screen goes here
  //  */
  // public void draw() {
    
  //   // Display welcome screen 
  //   //if(displayWelcomeScreen){
  //     //welcomeScreen();
  //   //}

  //   // Display take order screen
  //   if (displayTakeOrder){
  //     takeOrder();
  //   }

  //   // Player on level 1
  //   if (level1 && !outOfTime){  
  //     if (dipslayKitchen){
  //       kitchen();
  //     } 
  //     timer1(); 
  //     lives();
  //   }

  //   // Player on level 2
  //   if (level2 && !outOfTime){
  //     if (!mathAnswered){
  //       keyPad();
  //     }
  //     if(dipslayKitchen){
  //       kitchen();
  //     }
  //     timer1();
  //     lives();
  //   }
  //   // Did the player collect the right ingredient?
  //   //if (drawStars){
  //     //image(imgStars, xPizzaValue, 380);
  //   //}

  // }
  
  // /**
  //  * Loads images needed to run the program
  //  */
  // public void loadImages(){
    
  //   // Load Exterior of Dinner
  //   //imgExterior = loadImage("/Images/Diner_exteriorFull.png");
  //   //imgExterior.resize(width, height);

  //   // Load welcome sign
  //   //imgWelcome = loadImage("/Images/Welcome to.png");
  //   //imgWelcome.resize(300, 200);

  //   // Load heart
  //   for (int i = 0; i < drawHearts.length; i++){
  //     drawHearts[i] = loadImage("/Images/heart.png");
  //     drawHearts[i].resize(100, 100);
  //   }
  // }

  // /**
  //  * Loads images (of ingredients) needed to run the program 
  //  */
  // public void loadIngredients(){

  //   // Load image of pizza crust 
  //   imgPizzaCrust = loadImage("/Ingredients/Pizza Crust.png");
  //   imgPizzaCrust.resize(200, 200);

  //   // Assign fuirts a place in the array - drawIngredientImages
  //   //drawIngredientImages[0] = loadImage("/Ingredients/Cheese.png");
  //   //drawIngredientImages[1] = loadImage("/Ingredients/Basil.png");
  //   //drawIngredientImages[2] = loadImage("/Ingredients/Mushroom.png");

  // }

  // /**
  //  * Loads images needed to run the program 
  //  */
  
  // /**
  //  * Displays a welcome screen when called upon and utalizes user input
  //  */
  // /*
  //  * public void welcomeScreen(){
  //   background(imgExterior);
  //   image(imgWelcome, 100, 45);
  //   image(imgLogo, 150, 95);
  //   image(imgStart, 150, 235);
  //   image(imgTutorial, 150, 310);
  //   image(imgGallery, 150, 385);
  //   image(imgBy, 50, 470);
  // }
  //  */
  

  // /**
  //  * Displays an order station when called upon and utalizes user input
  //  */

  // /**
  //  * Draws a check mark when called upon for a certain period of time
  //  */

  // /**
  //  * Draws an 'x' mark when called upon for a certain period of time
  //  */

  // /**
  //  * Displays a kitchen when called upon and utalizes user input 
  //  */
    
  //   // Start count down
  //   if (!countdownFinished && Character1picked || !countdownFinished && Character2picked || !countdownFinished && Character3picked){
  //     countDown();
  //   }

  //   if (Character3picked){
  //     // Draw the needed ingredients
  //     fill(161, 159, 159);
  //     rect(0, 100, 70, 265);
  //     for (int i = 0 ; i < order3.length; i++){
  //       fill(135, 132, 122);
  //       image(drawIngredientImages[(int)order3[i]], 5, 100 + (i * 65));
  //     }
  //   }

  //   // Should I move the pizza
  //   if (xPizzaValue < 725 && movePizzaRight){
  //     xPizzaValue += 3;
  //     movePizzaRight = true;
  //   }
  //   if (xPizzaValue > 5 && movePizzaLeft){
  //     xPizzaValue -= 3;
  //     movePizzaLeft = true;
  //   }

  //   if (countdownFinished){
    
  //   // Determine the x-values for all of fruits if they go off screen
  //   for (int i = 0; i < drawIngredientImages.length; i++){
  //     if (yValueOfFruits[i] > height){
  //       yValueOfFruits[i] = 0;
  //       speedOfFruits[i] =  (float)random(4);
  //       xValueOfFruits[i] = random(width);
  //     }
  //   }

  //   // Draw the falling furits
  //   for (int i = 0; i < drawIngredientImages.length; i++){
  //     yValueOfFruits[i] += speedOfFruits[i];
  //     image(drawIngredientImages[i], xValueOfFruits[i], yValueOfFruits[i]);
  //   }

  //   // Collision detection + draw Stars or minus lives
  //   for (int i = 0; i < drawIngredientImages.length; i++) {
  //     if (xValueOfFruits[i] + 30 > xPizzaValue && xValueOfFruits[i] < xPizzaValue + 150 && yValueOfFruits[i] + 70 > 440) {
  //       if (currentIngredientIndex < order1.length && drawIngredientImages[(int)order1[currentIngredientIndex]] == drawIngredientImages[i]){
  //         yValueOfFruits[i] = height + 100;
  //         timeSinceStars = millis();
  //         drawStars = true;
  //         currentIngredientIndex++;
  //       } else {
  //         yValueOfFruits[i] = height + 100;
  //         numberOfLives--;
  //         if (numberOfLives == 0) {
  //           outOfTime = true;
  //           youLose();
  //         }
  //       }
  //     }          
  //   }

  //   // Draw stars 
  //   if (drawStars && millis() >= timeSinceStars + 1000) {
  //     drawStars = false;
  //   }
    
  //   if (drawStars && millis() >= timeSinceStars + 1000){
  //     drawStars = false;
  //   }

  //   if (currentIngredientIndex >= order1.length){
  //     gameWon = true;
  //     numberOfLives = 5;
  //   }
  //   }
  // }

  // /**
  //  * Displays a cout down scren (counts down from 3) when called upon 
  //  */
  // public void countDown(){
  //   if (!countdownStarted){
  //     startCountDown = millis();
  //     countdownStarted = true;
  //   }

  //   int elpasedTime = millis() - startCountDown;

  //   if (elpasedTime < 1000){
  //     image(img3, 325, 200);
  //   }
  //   else if (elpasedTime < 2000){
  //     image(img2, 325, 200);
  //   }
  //   else if (elpasedTime < 3000){
  //     image(img1, 325, 200);
  //   }
  //   else {
  //     // Reset the countdown for later
  //     countdownStarted = false;
  //   }

  //   if (elpasedTime >= 3000){
  //     countdownFinished = true;
  //   }

  // }
  
  // /**
  //  * Displays the tutorial home scren when called upon
  //  */
  // public void tutorial(){
  //   if (tutorialPage == 0){
  //     miniCollision = false;
  //     ongoingtutorial = true;
  //     image(imgtutorialScreen, 0, 0);
  //   }
  // }

  // /**
  //  * Displays a take order screen that can only be accessed trough the tutorial 
  //  */
  // public void miniTakeOrder(){
  //   image(imgOrderStation, 0, 0);
  //   image(imgCharacter1, 325, 99);
  //   fill(0);
  //   textSize(40);

  //   // Draw Notepad 
  //   textSize(30);
  //   fill(10);
  //   text("RECIPE", 10, 100);
  //   image(imgnotePad, 0, 125);    

  //   text("Click on the character", 20, 40);
    
  //   // Put the ingredients in the cabinets
  //   for (int i = 0; i < drawIngredientImages.length; i++){
  //     image(drawIngredientImages[i], fruitinCabinateX[i], fruitinCabinateY[i]);
  //   } 
  // }

  // /**
  //  * Displays another take order screen that can only be accessed through the tutorial
  //  */
  // public void miniTakeOrderpt2(){
  //   image(imgOrderStation, 0, 0);
  //   image(imgCharacter1, 325, 99);
  //   textSize(20);
  //   text("Drag the ingredients onto the recipe pad and then press k", 20, 40);

  //   // Draw Notepad 
  //   textSize(30);
  //   fill(10);
  //   text("RECIPE", 10, 100);
  //   image(imgnotePad, 0, 125);

  //   // Draw order
  //   image(imgThoughtBubble, 450, 50);
  //   for (int i = 0; i < 2; i++){
  //     image(drawIngredientImages[(int)order1[i]], 505 + i * 50, 85);
  //   }

  //   // Put the ingredients in the cabinets
  //   for (int i = 0; i < drawIngredientImages.length; i++){
  //     image(drawIngredientImages[i], fruitinCabinateX[i], fruitinCabinateY[i]);
  //   }     
  // }
  
  // /**
  //  * Displays a kitchen screen that can only be accessed through the tutorial
  //  */
  // public void miniKitchen(){
        
  //   background(imgKitchen);
  //   image(imgPizzaCrust, xPizzaValue, 420); 
    
  //   // Draw the needed ingredients
  //   fill(161, 159, 159);
  //   rect(0, 100, 70, 265);
  //   for (int i = 0 ; i < 2; i++){
  //     fill(135, 132, 122);
  //     image(drawIngredientImages[(int)order1[i]], 5, 100 + (i * 65));
  //   }

  //   // Should I move the pizza
  //   if (xPizzaValue < 625 && movePizzaRight){
  //     xPizzaValue += 3;
  //     movePizzaRight = true;
  //   }
  //   if (xPizzaValue > 5 && movePizzaLeft){
  //     xPizzaValue -= 3;
  //     movePizzaLeft = true;
  //   }
    
  //   // Draw the falling furits
  //   for (int i = 0; i < drawIngredientImages.length; i++){
  //     yValueOfFruits[i] += speedOfFruits[i];
  //     image(drawIngredientImages[i], xValueOfFruits[i], yValueOfFruits[i]);
  //   }

  //   // Collision detection + draw Stars or minus lives
  //   for (int i = 0; i < drawIngredientImages.length; i++) {
  //     if (xValueOfFruits[i] + 30 > xPizzaValue && xValueOfFruits[i] < xPizzaValue + 150 && yValueOfFruits[i] + 70 > 440) {
  //         onMiniKitchen = false;
  //         showMiniYouWin = true;
  //         break;
  //     }          
  //   }

  //   // Determine the x-values for all of fruits if they go off screen
  //   for (int i = 0; i < drawIngredientImages.length; i++){
  //     if (yValueOfFruits[i] > height){
  //       yValueOfFruits[i] = 0;
  //       speedOfFruits[i] =  (float)random(4);
  //       xValueOfFruits[i] = random(width);
  //     }
  //   }        
  // }

  // /***
  //  * Displays the amount of timer the player has left to complete a level 
  //  */
  // public void timer1(){
  //   rect(700, 20, 120, 20);
  //   fill(113, 171, 139);
  //   rect(700, 20, rectLength, 20);
  //   fill(0, 0, 0);
    
  //   elpasedTime = (millis() - startTimer1) / 1000;
  //   rectLength = 120 - elpasedTime;
  
  //   if (rectLength <= 0) {
  //     outOfTime = true;
  //     rectLength = 0;
  //     youLose();
  //   }
  // }
  
  // /***
  //  * 
  //  * Ensures that ingredients requested by the character are not duplicated
  //  * 
  //  * @param ingredients Intakes the ingredient requested
  //  * @return if the ingredient is already called upon or not
  //  */
  // public boolean isInThe2ndArray(float ingredients){
  //   for (int i = 0; i < order1.length; i++){
  //     if (order2[i] == ingredients){
  //       return true;
  //     }
  //   }
  //   return false;
  //   }

  //   /***
  //  * 
  //  * Ensures that ingredients requested by the character are not duplicated
  //  * 
  //  * @param ingredients Intakes the ingredient requested
  //  * @return if the ingredient is already called upon or not
  //  */
  // public boolean isInThe3rdArray(float ingredients){
  //   for (int i = 0; i < order1.length; i++){
  //     if (order2[i] == ingredients){
  //       return true;
  //     }
  //   }
  //   return false;
  //   }
  
  // /**
  //  * Does a certain funciton of the mouse is dragged
  //  * public void mouseDragged(){
  //   for (int i = 0; i < drawIngredientImages.length; i++){
  //     if (mouseX >= fruitinCabinateX[i] && mouseX <= fruitinCabinateX[i] + 55 && mouseY >= fruitinCabinateY[i] && mouseY <= fruitinCabinateY[i] + 70){
  //       fruitinCabinateX[i] += mouseX - pmouseX;
  //       fruitinCabinateY[i] += mouseY - pmouseY;
  //     }
  //   }
  // }
  //  */

  // /**
  //  * Does a certain function/action if a certain part of the screen is clicked on
  //  *   public void mouseClicked(){
  //   // Was start button pressed?
  //   if (mouseX >= 150 && mouseX <= 400 && mouseY >= 225 && mouseY <= 300){
  //     displayTakeOrder = true;
  //   }
  //  */

  //  /**
  //   * Does a certain function/action if a certain key is clicked on
  //     public void keyPressed(){
  //   if(key == 'k'){
  //     dipslayKitchen = true;
  //   }
  //   if (dipslayKitchen && keyCode == RIGHT){
  //     movePizzaRight = true;
  //   }
  //   if (dipslayKitchen && keyCode == LEFT){
  //     movePizzaLeft = true;
  //   }

  //   // Which gallery page should be displayed?
  //   if (keyCode == RIGHT) {
  //     if (galleryPage == 1) {
  //       galleryPage = 2;
  //     } else if (galleryPage == 2) {
  //       galleryPage = 3;
  //     }
  //   }
  //   */
    


  // /**
  //  * Stops a certain function/action from continuing if a certain key is clicked on 
  //  * public void keyReleased(){
  //   if (keyCode == RIGHT){
  //     movePizzaRight = false;
  //   }
  //   if (keyCode == LEFT){
  //     movePizzaLeft = false;
  //   }
  // }
  //  */

  // /**
  //  * Takes in a string inputted by the user
  //  * public void keyTyped(){
  //   if (key != CODED && !mathAnswered){
  //     userMathInput += key;
  //   }
  // }
  //  */
  

}
