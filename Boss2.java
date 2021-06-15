import DLibX.*;
import java.util.Random;
import java.util.ArrayList;

public class Boss2{
  int i = 0;
  private ArrayList<Crab> crabs2 = new ArrayList<>();//AL of crabs
  private Crab[] crabs = new Crab[10]; //This makes a max of crabs that can exist, stopping crashing hopefully
  private DConsole d; //Create a dconsole

  public int fightBoss(DConsole dc, int lives, int speed, int weapon){

    Random r = new Random();
    dc.setOrigin(DConsole.ORIGIN_CENTER);
    Player user = new Player();
    this.d = dc;

    user.setLives(lives);
    user.setSpeed(speed);
    int playerX = 20;
    int playerY = 40;
    int velX = 0;
    int velY = 0;

    dc.clear();
    dc.drawString("Boss Fight", dc.getWidth() / 2, dc.getHeight() / 2);
    dc.redraw();
    dc.pause(1000);


  createCrab(crabs, 200,200); //Crab Constructor, 
  createCrab(crabs, 300,300); //Crab Constructor, 
  createCrab(crabs, 200,500); //Crab Constructor, 

  createCrab(crabs, 600,200); //Crab Constructor, 
  

    while (user.getLives() > 0){
      dc.clear();
    
      // input
      if(dc.isKeyPressed('w')) {
        velY -= 2;
      }
      if(dc.isKeyPressed('a')) {
        velX -= 2;
      }
      if(dc.isKeyPressed('s')) {
        velY += 2;
      }
      if(dc.isKeyPressed('d')) {
        velX += 2;
      }

      //movments
      playerX += velX;
      playerY += velY;
      if(velX > 0){
        velX--;
      }
      if(velX < 0){
        velX++;
      }
      if(velY > 0){
        velY--;
      }
      if(velY < 0){
        velY++;
      }
      if(velX > 5){
        velX = 4;
      }
      if(velX < -5){
        velX = -4;
      }
      if(velY > 5){
        velY = 4;
      }
      if(velY < -5){
        velY = -4;
      }
      //heartBeat();
      int c = 0;
      while(crabs[c] != null) {
        crabs[c].draw();
        crabs[c].move();
        c++;
        //if(crabs[c].death()) {
        //  //crabs[c] = null;
        //}
       }

      //drawing 
      dc.fillEllipse(playerX, playerY, 30,30);
      dc.redraw();
      dc.pause(20);

      
      //this.d.clear();

      
      
  
    }

 //From this point the codebase is mine, this is just the movement code he created
  
  //player(this.d);
  

  while(this.d.isKeyPressed('q') == false) {
 
  }
  return -1;
}


/*This is one of my favorite pieces, this finds what
open spaces exist for a crab so all I need to do is null
the crab an it will eventually fill it up when we go to summon
another crab, this will solve so many random issues later*/
public Crab[] createCrab(Crab[] gibArray, int x, int y) {
boolean foundNull = false; 
int i = 0;
while(foundNull == false) { //have we found a null value
  if(gibArray[i] == null) { //Save the crab into that value, and then return the statement
    gibArray[i] = new Crab(x,y,this.d); //Creating the crab
    foundNull = true; //We found one
  }
   else {
    i++;
  }
}
return gibArray; //return it

}


 private class Crab {
   private int x;
   private int y;
   private DConsole dc;
   private int ani = 0;
   private boolean death = false;

   public Crab(int x, int y, DConsole d) {
     this.x = x;
     this.y = y;
     this.dc = d;
   }
   public void move() {
     this.x--;
     if(x <= 100) {
      this.death = true;
     }
   }
   public void draw() { 
     this.ani++;
     if(this.ani >= 3) {
       ani = 0;
     }
     dc.drawImage("Assets/Crab/Crab" + ani + ".png",this.x,this.y);
    
   }
   public boolean death() {
     return this.death;
   }
  public int giveX() {
    return this.x;
  }
 }


 }

