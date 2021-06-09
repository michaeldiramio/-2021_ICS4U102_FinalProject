import java.util.ArrayList;

public class Player {

  private int score = 0;
  private int lives = 3;
  private int shields = 0;

  // private ArrayList<Item> backpack = new ArrayList<>(); un-comment this if an Item class exists
  private double speed;

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

  public double getSpeed() {
    return this.speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }
}