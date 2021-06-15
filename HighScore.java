import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

class HighScore {

  File save = new File("save_file.txt");

  void saveScore(Player player) {

    try {

      FileWriter writer = new FileWriter(save);
      save.createNewFile(); // create file if its not there

      writer.write(" "); // clear file

      for (int x = 0; x < 10; x++) {

        writer.append(player.name + " " + player.score);

        writer.append("\n");

      }

      writer.close();
    } catch (Exception e) {
      System.out.println("Failed to save");
    }

  }

  void loadScore() {

    try {

      Scanner reader = new Scanner(save);

      for (int x = 0; x < 10; x++) {

        System.out.print(reader.nextLine());

      }
      reader.close();
    } catch (Exception e) {

    }

  }

}