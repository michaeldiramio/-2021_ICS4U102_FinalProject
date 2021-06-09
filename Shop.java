import DLibX.*;
import java.awt.Color;
import java.awt.Font;

public class Shop {

  //ints to keep track of what items are bought in the Shop
  static int speedOne = 0;
  static int speedTwo = 0;
  static int livesBought = 0;
  static int sheildsBought = 0;

  int score;
  DConsole dc;
  //function to get player score will be in main where this is called
  public Shop(DConsole dc, int score) {
    //basic setup for origin and paint color font can be added later if needed
    dc.setPaint(Color.BLACK);
    dc.setOrigin(DConsole.ORIGIN_TOP_LEFT);

    this.dc = dc;
    this.score = score;
    
  }

  public void openShop() {

    while(true) {
      dc.clear();
      
      //draw background
      dc.setPaint(Color.lightGray);
      dc.fillRect(0, 0, dc.getWidth(), dc.getHeight());
      
      //draw title
      dc.setFont(new Font("Arial", 40));
      dc.drawString("SHOP", dc.getWidth() / 2, dc.getHeight() / 2);

      dc.redraw();
      dc.pause(20);

    }


    //reset function at end of shopping
    Shop.resetShop();
  }

  //one function that tells which item the player clicks on and buys it instead of several seperate ones
  public void itemCounter(){

    
  }

  //functions below are for returning item numbers to the player
  public int getSpeedOne(){
    return speedOne;
  }
  public int getSpeedTwo(){
    return speedTwo;
  }
  public int getSheildsBought(){
    return sheildsBought;
  }
  public int getLivesBought(){
    return livesBought;
  }

  //resets the item bought at the end of the players shopping
  public static void resetShop(){
    speedOne = 0;
    speedTwo = 0;
    sheildsBought = 0;
    livesBought = 0;
  }

  
  
  

}