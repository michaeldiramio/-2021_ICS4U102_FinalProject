import DLibX.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class Shop {

  //ints to keep track of what items are bought in the Shop

  static int shields = 0;
  static int lives = 0;
  static int speedOnes = 0;
  static int speedTwos = 0;

  boolean itemsSent = true;
  static boolean useLife;
  static boolean useShield;
  static boolean useSpeedOne;
  static boolean useSpeedTwo;

  int score;
  DConsole dc;
  //function to get player score will be in main where this is called
  public Shop(DConsole dc, Player player) {
    //basic setup for origin and paint color font can be added later if needed
    dc.setPaint(Color.BLACK);
    dc.setOrigin(DConsole.ORIGIN_TOP_LEFT);

    int score = player.getScore();
    
  }

  public void openShop() {

    boolean shop = true;
    boolean equip = false;
    useLife = false;
    useShield = false;
    useSpeedOne = false;
    useSpeedTwo = false;
    dc.setOrigin(DConsole.ORIGIN_CENTER);

    while(shop == true) {
      dc.clear();
      itemsSent = true;

      //draw background
      dc.setPaint(Color.lightGray);
      dc.fillRect(dc.getWidth() / 2, dc.getHeight() / 2, dc.getWidth(), dc.getHeight());
      
      //draw title
      dc.setPaint(Color.BLACK);
      dc.setFont(new Font("Impact", Font.PLAIN, 36));
      dc.drawString("SHOP", dc.getWidth() / 2, 40);
      dc.setFont(new Font("Impact", Font.PLAIN, 20));
      dc.drawString ("PRESS THE ITEM NUMBER TO BUY", dc.getWidth() / 2, 80);
      dc.drawString("PRESS 'SPACE' TO GO TO EQUIP SCREEN", dc.getWidth() / 2, 385);
      dc.setFont(new Font("Impact", Font.PLAIN, 15));
      dc.drawString("Score: ", dc.getWidth() / 4, 50);
      dc.drawString(score, (dc.getWidth() / 4) - 10, 50);

      //creating 4x2 grid
      dc.setPaint(Color.BLACK);
      dc.drawRect((dc.getWidth() / 2) + 65, 165, 100, 100); //3
      dc.drawRect((dc.getWidth() / 2) + 200, 165, 100, 100); //4
      dc.drawRect((dc.getWidth() / 2) - 65, 165, 100, 100); //2
      dc.drawRect((dc.getWidth()/ 2) - 200, 165, 100, 100); //1
      dc.drawRect((dc.getWidth() / 2) + 65, 310, 100, 100); //7
      dc.drawRect((dc.getWidth() / 2) + 200, 310, 100, 100); //8
      dc.drawRect((dc.getWidth() / 2) - 65, 310, 100, 100); //6
      dc.drawRect((dc.getWidth()/ 2) - 200, 310, 100, 100); //5

      //drawing things to buy
      dc.drawImage("shopimages/shield.png", (dc.getWidth() / 2) - 200, 165);
      dc.drawImage("shopimages/heart.png", (dc.getWidth() / 2) - 65, 165);
      dc.drawImage("shopimages/speedup.png", (dc.getWidth() / 2) + 65, 165);
      dc.drawImage("shopimages/speedup2.png", (dc.getWidth() / 2) + 200, 165);
      dc.drawImage("shopimages/shield.png", (dc.getWidth() / 2) - 200, 310);
      dc.drawString("x3", (dc.getWidth() / 2) - 235, 340);
      dc.drawImage("shopimages/heart.png", (dc.getWidth() / 2) - 65, 310);
      dc.drawString("x3", (dc.getWidth() / 2) - 100, 340);
      dc.drawImage("shopimages/speedup.png", (dc.getWidth() / 2) + 65, 310);
      dc.drawString("x3", (dc.getWidth() / 2) + 30, 340);
      dc.drawImage("shopimages/speedup2.png", (dc.getWidth() / 2) + 200, 310);
      dc.drawString("x3", (dc.getWidth() / 2) + 165, 340);

      //adds item numbers to frames
      dc.drawString("1", (dc.getWidth() / 2) - 160, 195);
      dc.drawString("2", (dc.getWidth() / 2) - 25, 195);
      dc.drawString("3", (dc.getWidth() / 2) + 105, 195);
      dc.drawString("4", (dc.getWidth() / 2) + 240, 195);
      dc.drawString("5", (dc.getWidth() / 2) - 160, 340);
      dc.drawString("6", (dc.getWidth() / 2) - 25, 340);
      dc.drawString("7", (dc.getWidth() / 2) + 105, 340);
      dc.drawString("8", (dc.getWidth() / 2) + 240, 340);

      //shows prices for items and bulk items
      dc.drawString("50/125", (dc.getWidth() / 2) - 200, 235);
      dc.drawString("100/250", (dc.getWidth() / 2) - 65, 235);
      dc.drawString("100/250", (dc.getWidth() / 2) + 65, 235);
      dc.drawString("150/375", (dc.getWidth() / 2) + 200, 235);

      //checks to see if the pplayer has bought an item
      if(dc.isKeyPressed(49) && score >= 50){
        shields++;
        score = score - 50;
      }else if(dc.isKeyPressed(50) && score >= 100){
        lives ++;
        score = score - 100;
      }else if(dc.isKeyPressed(51) && score >= 100){
        speedOnes++;
        score = score - 100;
      }else if(dc.isKeyPressed(52) && score >= 150){
        speedTwos ++;
        score = score - 150;
      }else if(dc.isKeyPressed(53) && score >= 125){
        shields = shields + 3;
        score = score - 125;
      }else if(dc.isKeyPressed(54) && score >= 250){
        lives = lives + 3;
        score = score - 250;
      }else if(dc.isKeyPressed(55) && score >= 250){
        speedOnes = speedOnes + 3;
        score = score - 250;
      }else if(dc.isKeyPressed(56) && score >= 375){
        speedTwos = speedTwos + 3;
        score = score - 375;
    }

      //checks
      if(dc.isKeyPressed(32)) {
        shop = false;
        equip = true;
      }
      dc.redraw();
      dc.pause(20);

    }

    dc.pause(100);
    itemsSent = false;

    while(equip == true) {
      itemsSent = true;
      
      dc.clear();
      
      //draw background
      dc.setPaint(Color.lightGray);
      dc.fillRect(dc.getWidth() / 2, dc.getHeight() / 2, dc.getWidth(), dc.getHeight());
      
      //draw title
      dc.setPaint(Color.BLACK);
      dc.setFont(new Font("Impact", Font.PLAIN, 36));
      dc.drawString("EQUIP", dc.getWidth() / 2, 40);
      dc.setFont(new Font("Impact", Font.PLAIN, 26));
      dc.drawString ("PRESS THE ITEM NUMBER TO EQUIP", dc.getWidth() / 2, 70);
      dc.setFont(new Font("Impact", Font.PLAIN, 20));
      dc.drawString("PRESS 'SPACE' TO START GAME", dc.getWidth() / 2 ,380);

      //creating 4x2 grid
      dc.setPaint(Color.BLACK);
      dc.drawRect((dc.getWidth() / 2) + 65, 165, 100, 100); //3
      dc.drawRect((dc.getWidth() / 2) + 200, 165, 100, 100); //4
      dc.drawRect((dc.getWidth() / 2) - 65, 165, 100, 100); //2
      dc.drawRect((dc.getWidth()/ 2) - 200, 165, 100, 100); //1
      dc.drawRect((dc.getWidth() / 2) + 65, 310, 100, 100); //7
      dc.drawRect((dc.getWidth() / 2) + 200, 310, 100, 100); //8
      dc.drawRect((dc.getWidth() / 2) - 65, 310, 100, 100); //6
      dc.drawRect((dc.getWidth()/ 2) - 200, 310, 100, 100); //5

      //draw items
      dc.drawImage("shopimages/shield.png", (dc.getWidth() / 2) - 200, 165);
      dc.drawImage("shopimages/heart.png", (dc.getWidth() / 2) - 65, 165);
      dc.drawImage("shopimages/speedup.png", (dc.getWidth() / 2) + 65, 165);
      dc.drawImage("shopimages/speedup2.png", (dc.getWidth() / 2) + 200, 165);

      //adds item numbers to frames
      dc.drawString("1", (dc.getWidth() / 2) - 160, 195);
      dc.drawString("2", (dc.getWidth() / 2) - 25, 195);
      dc.drawString("3", (dc.getWidth() / 2) + 105, 195);
      dc.drawString("4", (dc.getWidth() / 2) + 240, 195);

      //drawing check and x mark
      if(useShield == true) {
        dc.drawImage("shopimages/checkmark.png", (dc.getWidth() / 2) -200, 310);

      } else {
        dc.drawImage("shopimages/xmark.png", (dc.getWidth() / 2) -200, 310);
      }
      if(useLife == true) {
        dc.drawImage("shopimages/checkmark.png", (dc.getWidth() / 2) -65, 310);
      } else {
        dc.drawImage("shopimages/xmark.png", (dc.getWidth() / 2) -65, 310);
      }
      if(useSpeedOne == true) {
        dc.drawImage("shopimages/checkmark.png", (dc.getWidth() / 2) + 65, 310);
      } else {
        dc.drawImage("shopimages/xmark.png", (dc.getWidth() / 2) + 65, 310);
      }
      if(useSpeedTwo == true) {
        dc.drawImage("shopimages/checkmark.png", (dc.getWidth() / 2) + 200, 310);
      } else {
        dc.drawImage("shopimages/xmark.png", (dc.getWidth() / 2) + 200, 310);
      }

      //checks
      if(dc.isKeyPressed(' ')) {
        equip = false;
      }

      if(dc.isKeyPressed(49) && shields > 0) {
        dc.pause(200);
        if(useShield == false) {
          useShield = true;
          shields--;
        } else {
          useShield = false;
        }
      }

      if(dc.isKeyPressed(50) && lives > 0) {
        dc.pause(200);
        if(useLife == false) {
          useLife = true;  
          lives--;
        } else {
          useLife = false;
          lives++;
        }
      }

      if(dc.isKeyPressed(51) && speedOnes > 0) {
        dc.pause(200);
        if(useSpeedOne == false) {
          useSpeedOne = true;
          speedOnes--;
        } else {
          useSpeedOne = false;
          speedOnes++;
        }
      }

      if(dc.isKeyPressed(52) && speedTwos > 0) {
        dc.pause(200);
        if(useSpeedTwo == false) {
          useSpeedTwo = true;
          speedTwos--;
        } else {
          useSpeedTwo = false;
          speedTwos++;
        }
      }
      
      dc.redraw();
      dc.pause(20);
    }

    dc.clear();
  }

  //methods for other classes to check if user decided to equip item or not
  public boolean checkSpeedOne() {
    return useSpeedOne;
  }
  public boolean checkSpeedTwo() {
    return useSpeedTwo;
  }
  public boolean checkLife() {
    return useLife;
  }
  public boolean checkShield() {
    return useShield;
  }
  
  
  public boolean checkItems(){
    return itemsSent;
  }

  //methods for player class to get numbers of items purchased
  public int sendLives(){
    return lives;
  }
  public int sendShields(){
    return shields;
  }
  public int sendSpeedOnes(){
    return speedOnes;
  }
  public int sendSpeedTwos(){
    return speedTwos;
  }
}