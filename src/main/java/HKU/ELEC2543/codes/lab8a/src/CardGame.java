import java.util.*;

public class CardGame {
  private RandomPlayer p1;
  private LCPlayer p2;
  private SCPlayer p3;
  private TrumpDeck deck;
  private int k;

  public CardGame(int k, Suit trumpSuit) {

    deck = new TrumpDeck(trumpSuit);
    Player.setDeck(deck);
    p1 = new RandomPlayer(1);
    p2 = new LCPlayer(2);
    p3 = new SCPlayer(3);
    this.k = k;
    
  }

  public void play() {
		
	  for (int i = 1; i <= k; i++){
		  p1.addCard(deck.drawCard());
		  p2.addCard(deck.drawCard());
		  p3.addCard(deck.drawCard());
	  }

		for (int i = 0; i < k; i++)
		{
			p1.printHand();
			p2.printHand();
			p3.printHand();
			
			Card c1 = p1.drawCard();
			Card c2 = p2.drawCard();
			Card c3 = p3.drawCard();
			System.out.println("Player 1 deals " + c1);
			System.out.println("Player 2 deals " + c2);
			System.out.println("Player 3 deals " + c3);
		    
			if (deck.compareCards(c1, c2) < 0){
		    	if (deck.compareCards(c2, c3) < 0)
		    		System.out.println("Player 3 wins in this round!\n");
		    	else 
		    		System.out.println("Player 2 wins in this round!\n");
			}
		    else{
		    	if (deck.compareCards(c1, c3) < 0)
		    		System.out.println("Player 3 wins in this round!\n");
		    	else 
		    		System.out.println("Player 1 wins in this round!\n");
		    }
		}
  }
}
