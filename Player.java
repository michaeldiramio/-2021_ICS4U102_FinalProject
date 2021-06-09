import java.util.ArrayList;

public class Player {

  private int score = 0;
  private int lives = 3;
  private boolean shield = false;

  // private ArrayList<Item> backpack = new ArrayList<>();
  // Un-comment this if an Item class exists.


  // will only ever be 1, 2 or 3
  // 1 = default, 2 = single speed, 3 = double speed
  private int speed = 1;


  public int getScore() {
    return this.score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getLives() {
    return this.lives;
  }

  public void setLives(int lives) {
    this.lives = lives;
  }

  // removes 1 shield whenever the player would lose a life, and removes a life if the player doesn't have a shield
  public void takeDamage() {
    if (this.shield) {
      this.shield = false;
    } else {
      this.lives--;
    }
  }

  public boolean getShield() {
    return this.shield;
  }

  public void setShield(boolean shield) {
    this.shield = shield;
  }

  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  // reverts player back to default, to be used after each minigame, parameter increases score
  public void playerReset (int scoreGained) {
    this.shield = false;
    this.speed = 1;
    this.score += scoreGained;
  }

  // version of the previous method that doesn't affect score
  public void playerReset () {
    this.shield = false;
    this.speed = 1;
  }
}