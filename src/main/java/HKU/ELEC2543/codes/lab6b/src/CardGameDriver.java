// YOU SHOULD NOT MODIFY THIS FILE

public class CardGameDriver {

  public static void main(String[] args) {

    int k = Integer.parseInt(args[0]);
    CardGame game = new CardGame(k);
    game.play();
  }
}
