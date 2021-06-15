 import DLibX.*;
import MiniGames.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    //declaring variables
    DConsole dc = new DConsole(600,400);
    dc.setOrigin(DConsole.ORIGIN_CENTER);
    Random r = new Random();
    Player player = new Player();
    Boss boss = new Boss();
    Shop shop = new Shop(dc, player);


    ArrayList<MiniGame> game = new ArrayList<>();
    //add games here vvvvv
    //basic format game.add(new ______());
    //game.add(new FlappyBird());
    game.add(new PerfectTiming());
    //game.add(new UpOrDown());

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
      shop.openShop(player.getScore());
      dc.pause(2000);
      level++;
      if(level + 1 > games.size()){
        System.out.println(boss.fightBoss(dc, player.getLives(),player.getSpeed(), 0));
        inGame = false;
      }
    }
    
    // public void playerInitialize(Shop s) {
    // player.setLives(player.getLives() + s.sendLives());
    // player.setShieldsOwned(s.sendShields());
    // player.setSpeed1Owned(s.sendSpeedOnes());
    // player.setSpeed2Owned(s.sendSpeedTwos());
  }
  }