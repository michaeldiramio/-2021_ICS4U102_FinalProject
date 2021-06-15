import DLibX.DConsole;
import java.awt.Color;
import java.util.Random;
//import java.Font.Util;

public class StartScreen {

  public static void main(String[] args) {

    DConsole dc = new DConsole(600, 400);
    Random rand = new Random();

    while (true) {
      dc.setOrigin(DConsole.ORIGIN_CENTER);

      // Random Colour Variables
      float r = rand.nextFloat();
      float g = rand.nextFloat();
      float b = rand.nextFloat();
      Color randomColor = new Color(r, g, b);

      dc.clear();
    //Background
      dc.setPaint(new Color(255, 204, 255));
      dc.setPaint(new Color(r, g, b));
      dc.fillRect(dc.getWidth() / 2, dc.getHeight() / 2, 600, 400);

    //Title
      dc.fillRect(dc.getWidth() / 2, dc.getHeight() / 2, 600, 400);
      // f = createFont("Arial", 20,true);
      dc.setPaint(Color.WHITE);
      dc.fillRect(dc.getWidth() / 2, dc.getHeight() / 4, 200, 50);
      dc.setPaint(Color.BLACK);
      // dc.setFont(new Font("Times New Roman", Font.PLAIN, 36));
      dc.drawString("INSERT GAME TITLE HERE", dc.getWidth() / 2, dc.getHeight() / 4);
 
      dc.setPaint(Color.WHITE);
      dc.fillRect(dc.getWidth() / 2, dc.getHeight() / 3, 200, 50);
      dc.setPaint(Color.BLACK);
      dc.drawString("PRESS 'P' TO PLAY", dc.getWidth() / 2, dc.getHeight() /3);



      dc.redraw();
      dc.pause(1000);
    }
  }

}