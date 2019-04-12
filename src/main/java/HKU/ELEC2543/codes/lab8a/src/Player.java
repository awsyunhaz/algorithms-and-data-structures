import java.util.*;

public abstract class Player{
  protected ArrayList<Card> cards;
  protected static Deck deck;
  protected int id;

  public static void setDeck(Deck deck) {
    Player.deck = deck;
  }

  public Player(int id) {
    cards = new ArrayList<Card>();
    this.id = id;
  } 

  public void addCard(Card card) {
	  cards.add(card);
  }

  public abstract Card drawCard();


  public void printHand() {
	  System.out.println("Player " + id + " has cards " + cards);
  }
}
