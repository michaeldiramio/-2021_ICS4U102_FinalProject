   //final boss here
import DLibX.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;


public class Boss{
  
  public int fightBoss(DConsole dc, int lives, int speed, int weapon){
    Random r = new Random();
    dc.setOrigin(DConsole.ORIGIN_CENTER);
    Player user = new Player();

    user.setLives(lives);
    user.setSpeed(speed);
    int playerX = 20;
    int playerY = 40;
    int velX = 0;
    int velY = 0;
    int boss = 0;
    int timer = 0;

    int babyX = 300;
    int babyY = 150;
    int targetX = -1;
    int targetY = -1;
    int babyVelX = 0;
    int babyVelY = 0;
    dc.setOrigin(DConsole.ORIGIN_CENTER);
    dc.clear();
    dc.drawString("Boss Fight", dc.getWidth() / 2, dc.getHeight() / 2);
    dc.redraw();
    dc.pause(1000);
    while (user.getLives() > 0){
      dc.clear();
      dc.setPaint(Color.GREEN);
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

      //drawing 
      dc.fillEllipse(playerX, playerY, 30,30);

      //----------------------First Boss------------------------
      if(boss == 0){
        if(targetX == -1){//set targetx
          targetX = playerX;
          babyVelX = (babyX - playerX)/20;
        }
        if(targetY == -1){//set targetY
          targetY = playerY;
          babyVelY = (babyY - playerY)/20;
        }
        
        if(timer > 50){
          babyX -= babyVelX;
          babyY -= babyVelY;
        }
        if(timer > 70){
          targetX = -1;
          targetY = -1;
          timer = 0;
        }
        

        //collisions
        int xDist = babyX - playerX;
        int yDist = babyY - playerY;
        if(Math.sqrt((xDist * xDist)+(yDist * yDist)) < 40){
          user.takeDamage();
          babyX = 700;
          babyY = 150;
        }
        
       
        timer++; 

        dc.fillEllipse(babyX, babyY, 50, 50);
        
      }
      
      
        


      
      dc.redraw();
      dc.pause(20);
    }
    return -1;
  }
  
}