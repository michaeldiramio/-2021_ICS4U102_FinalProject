import DLibX.*;

public class Main {

  public static void main(String[] args) {
    // Testing that DConsole works
    DConsole dc = new DConsole(600, 400);

    //testing shop
    Shop shop = new Shop(dc, 0);

    shop.openShop();

  }

}