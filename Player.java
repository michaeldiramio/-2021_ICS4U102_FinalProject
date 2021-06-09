import java.util.ArrayList;

public class Player {

  private int score = 0;
  private int lives = 3;
  private int shields = 0;

  // private ArrayList<Item> backpack = new ArrayList<>();
  // Un-comment this if an Item class exists.

  // a multiplier to be used on anything affected by speed, altered with items
  private int speed = 0;

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
    if (this.shields > 0) {
      this.shields--;
    } else {
      this.lives--;
    }
  }

  public int getShields() {
    return this.shields;
  }

  public void setShields(int shields) {
    this.shields = shields;
  }

  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  // reverts player back to default, to be used after each minigame, parameter increases score
  public void playerReset (int scoreGained) {
    this.shields = 0;
    this.speed = 1;
    this.score += scoreGained;
  }

  // version of the previous method that doesn't affect score
  public void playerReset () {
    this.shields = 0;
    this.speed = 1;
  }
}