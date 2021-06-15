import java.util.ArrayList;

public class Player {

  private int score = 0;
  private int lives = 3;
  private boolean shield = false;

  // player owns but isn't using
  private int shieldsOwned = 0;
  private int speed1Owned = 0;
  private int speed2Owned = 0;

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

  public int getShieldsOwned() {
    return this.shieldsOwned;
  }

  public void setShieldsOwned(int shieldsOwned) {
    this.shieldsOwned = shieldsOwned;
  }

  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getSpeed1Owned() {
    return this.speed1Owned;
  }

  public void setSpeed1Owned(int speed1Owned) {
    this.speed1Owned = speed1Owned;
  }

  public int getSpeed2Owned() {
    return this.speed2Owned;
  }

  public void setSpeed2Owned(int speed2Owned) {
    this.speed2Owned = speed2Owned;
  }

  // prints all of the players items
  public void listInventory() {
    System.out.println("Shields in backback: " + this.shieldsOwned + ".");
    System.out.println("Speed 1s in backback: " + this.speed1Owned + ".");
    System.out.println("Speed 2s in backback: " + this.speed2Owned + ".");
  }

  // uses an item owned by the player
  public void useShield() {
    if (this.shieldsOwned > 0 && !this.shield) {
      this.shieldsOwned --;
      this.shield = true;
    }
  }

  public void useSpeed1() {
    if (this.speed1Owned > 0 && this.speed == 1) {
      this.speed1Owned --;
      this.speed = 2;
    }
  }

  public void useSpeed2() {
    if (this.speed2Owned > 0 && this.speed == 1) {
      this.speed2Owned --;
      this.speed = 3;
    }
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