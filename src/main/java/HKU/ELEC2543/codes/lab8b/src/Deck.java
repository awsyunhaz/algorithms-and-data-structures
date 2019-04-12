// YOU CANNOT MODIFY THIS FILE
import java.util.*;

public class Deck {
  protected ArrayList<Card> cards;

  public Deck() {
    cards = new ArrayList<Card>();

    for (Suit s : Suit.values())
      for (Rank r : Rank.values())
	cards.add(new Card(r, s));
  } 
 
  // smaller rank means a larger card
  // the largest card is of rank 1
  // SA is the largest and D2 is the smallest
  // rank of SA:1 ; rank of D2: 52
  public int cardRank(Card card) {
    return (12 - card.getRank().ordinal())*4 + card.getSuit().ordinal() + 1;
  }

  // return -ve number if c1 is smaller than c2
  // return 0 if c1 is the same as c2
  // return +ve number if c1 is larger than c2
  public int compareCards(Card c1, Card c2) {
    return cardRank(c2) - cardRank(c1);
  }

  // randomly draw a card from the deck
  // the drawn card is removed from the deck
  public Card drawCard() {
    if (cards.size() == 0) return null;

    Random generator = new Random();
    int i = generator.nextInt(cards.size());

    return cards.remove(i); 
  }

  public boolean isEmpty() {
    return (cards.size() == 0);
  }

  public void printDeck() {
    System.out.println(cards);
  }
}
