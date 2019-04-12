public class TrumpCardGame {
	
  private Player[] players;
  private TrumpDeck deck;
  private int k;

  public TrumpCardGame(int k, Suit trumpSuit, Player[] p) {

    deck = new TrumpDeck(trumpSuit);
    Player.setDeck(deck);
    this.k = k;
    players = p;
    
  }

  public void play() {
		
	  for (int i = 1; i <= k; i++){
		  for (Player px:players)
			  px.addCard(deck.drawCard());
	  }

		for (int i = 1; i <= k; i++)
		{
			System.out.println("Round " + i);
			for (Player px:players)
				px.printHand();
			
			((CheatPlayer) players[0]).cheat();
			System.out.println("After cheating...");
			players[0].printHand();
			
			int id = 0;
			Card c = players[0].drawCard();
			System.out.print("Player 0 deals " + c + "; ");
			int j = 1;
			do{
				Card c1 = players[j].drawCard();
				System.out.print("Player " + j + " deals " + c1 + "; ");
				if (deck.compareCards(c, c1) < 0){
					c = c1;
					id = j;
				}
				j++;
			}while (j < players.length);
			
			System.out.println();
			System.out.println("Player " + id + " wins this round!");
			players[id].addWin();
			
			for (Player px:players)
				System.out.println("Player " + px.getId() + " has won " + px.getWin() + " rounds.");
			System.out.println();
		}
  }
}
