// YOU SHOULD NOT MODIFY THIS FILE

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
  public int cardRank(Card card) {
    return (12 - card.getRank().ordinal())*4 + card.getSuit().ordinal() + 1;
  }

  public int compareCards(Card c1, Card c2) {
    return cardRank(c2) - cardRank(c1);
  }

  public void putCard(Card c) {
    cards.add(c);
  }

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
