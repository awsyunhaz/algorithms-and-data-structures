// We will use our own driver program to test your program

public class Lab8bTrumpCardGameDriver {

  public static void main(String[] args) {

    int numCards = 8;		// number of cards obtained in the beginning
    Player[] p = new Player[5]; // array for the players

    p[0] = new CheatPlayer(0);	// p[0] is always the cheating player
				// all others are non-cheating player

    p[1] = new LCPlayer(1);
    p[2] = new SCPlayer(2);
    p[3] = new RandomPlayer(3);
    p[4] = new RandomPlayer(4);
    TrumpCardGame game = new TrumpCardGame(numCards, Suit.HEART, p);
    game.play();
  }
}
