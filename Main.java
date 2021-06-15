import DLibX.*;
import MiniGames.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    
    // credit to DiRamio and respective classmates for a portion of this code
    DConsole dc = new DConsole(600,400);
    dc.setOrigin(DConsole.ORIGIN_CENTER);
    Random r = new Random();
    Player player = new Player();
    Boss boss = new Boss();

    ArrayList<MiniGame> game = new ArrayList<>();


      
      MiniGame sg = new Boss2();
      sg.playGame(dc);



      //add games here vvvvv
    game.add(new FlappyBird());
    game.add(new PerfectTiming());
    game.add(new UpOrDown());


    //sorting MiniGames
    ArrayList<MiniGame> games = new ArrayList<>();
    int arraySize = game.size();
    for(int i = 0; i < arraySize; i++){
      MiniGame temp = game.get(r.nextInt(game.size()));
      games.add(temp);
      game.remove(temp);
    }
    // play games FOREVER!
    int level = 0;
    boolean inGame = true;
    while(inGame) {
      
      MiniGame current = games.get(level); // randomly choose a game
      player.playerReset(current.playGame(dc));//play game and save score

      
      dc.pause(2000);
      level++;

      
      
    }



      if(level + 1 > games.size()){
        System.out.println(boss.fightBoss(dc, player.getLives(),player.getSpeed(), 0));
        inGame = false;
      }
    }
    
    

  }


