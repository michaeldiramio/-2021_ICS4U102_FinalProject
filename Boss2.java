import DLibX.*;
import java.util.Random;
import java.util.ArrayList;

public class Boss2 implements MiniGame {
  int i = 0;
  private ArrayList<Crab> crabs2 = new ArrayList<>();//AL of crabs
  private Crab[] crabs = new Crab[100]; //This makes a max of crabs that can exist, stopping crashing hopefully
  private DConsole d; //Create a dconsole

  public int playGame(DConsole dc) { //Starting the game
  Random r = new Random(); //Creating a random
  this.d = dc;
  //player(this.d);
  
  createCrab(crabs, 200,200); //Crab Constructor, 
  createCrab(crabs, 300,300); //Crab Constructor, 
  createCrab(crabs, 200,500); //Crab Constructor, 
  createCrab(crabs, 200,600); //Crab Constructor, 
  createCrab(crabs, 600,200); //Crab Constructor, 
  createCrab(crabs, 200,800); //Crab Constructor, 

  while(this.d.isKeyPressed('q') == false) {
  int c = 0;
  this.d.clear();

  //heartBeat();
  while(crabs[c] != null) {
    crabs[c].draw();
    crabs[c].move();
    c++;
  }
  this.d.redraw();
  this.d.pause(20);
  
  }
  return -1;
}

 boolean findNull = false;
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

   public Crab(int x, int y, DConsole d) {
     this.x = x;
     this.y = y;
     this.dc = d;
   }
   public void move() {
     this.x--;
   }
   public void draw() {
     this.ani++;
     if(this.ani >= 3) {
       ani = 0;
     }
     dc.drawImage("Assets/Crab/Crab" + ani + ".png",this.x,this.y);
    
   }
 }

 private class player {
   private int x = 0;
   private int y = 0;
   private DConsole dc;

   public player(DConsole d) {
     this.dc = d;
   }
 

  public void heartBeat() {
    this.dc.drawImage("Assets/Crab/Crab0.png", this.x, this.y);
  }

  public int giveX() {
    return this.x;
  }

  public int giveY() {
    return this.y;
  }
}
 }

