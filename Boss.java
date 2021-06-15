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

    dc.clear();
    dc.drawString("Boss Fight", dc.getWidth() / 2, dc.getHeight() / 2);
    dc.redraw();
    dc.pause(1000);

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

      //drawing 
      dc.fillEllipse(playerX, playerY, 30,30);
      dc.redraw();
      dc.pause(20);
    }
    return -1;
  }
  
}