// You can define instance variables and methods as needed

import java.util.ArrayList;

public class Lab9Player{
  protected ArrayList<Card> cards;    // cards the player has
  protected static Deck deck;	      // the deck of the game
 
  // constructor
  public Lab9Player() {
    cards = new ArrayList<Card>();
  }

  // assign deck
  public static void setDeck(Deck d) {
    deck = d;
  }

  // add a card to hand
  // cards are sorted from smaller cards to larger cards
  public void addCard(Card card) {

    int pos = 0;
    while (pos < cards.size() && deck.compareCards(cards.get(pos), card) < 0) pos++;

    cards.add(pos, card);
  }

  // return true if the player has Card c 
  public boolean hasCard(Card c) {
    int pos = 0;
    while (pos < cards.size())
      if (c.equals(cards.get(pos++))) return true;

    return false;
  }

  // remove Card c from the player
  // returns true if the player has the card; false otherwise
  public boolean removeCard(Card c) {
    int pos = 0;
    while (pos < cards.size())
      if (c.equals(cards.get(pos))) {
	cards.remove(pos);
        return true;
      }
      else {
	pos++;
      }
   return false;
  }

  // return the number of cards the player has
  public int numCardsInHand() {
    return cards.size();
  }

  // return true if the player has no card
  public boolean emptyHand() {
    return (cards.size() == 0);
  }

  // print out the cards the player has
  public void printHand() {
    System.out.println(cards);
  }

  // IMPLEMENT THIS METHOD
  // return the card dealt 
  // the parameter can be the current biggest card played so far
  public Card dealCard(Object object) {
	  
	  int i = 0;
	  
	  do{
		  if (deck.cardRank(cards.get(i)) < deck.cardRank((Card)object))				  
			  return cards.get(i);
		  i++;
		 }while (i <= numCardsInHand()-1);
	  
	  return null;
  }
  
}
