//final boss here
import DLibX.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;

public class Boss{
  
  public int fightBoss(DConsole dc, int lives, int speed, int weapon){
    Random r = new Random();
    dc.setOrigin(DConsole.ORIGIN_CENTER);
    Player player = new Player();

    player.setLives(lives);
    player.setSpeed(speed);
      
    dc.clear();
    dc.drawString("Boss Fight", dc.getWidth() / 2, dc.getHeight() / 2);
    dc.redraw();
    dc.pause(1000);

    while (player.getLives() > 0){
      dc.clear();
    
      // player movement
      if(dc.isKeyPressed('a')) {
        //playerX -= 8;
      }
      if(dc.isKeyPressed('d')) {
        //playerX += 8;
      }

      dc.redraw();
      dc.pause(20);
    }
    return -1;
  }
  
}