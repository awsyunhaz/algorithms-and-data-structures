// You have to implement the methods specified
// You can define new methods

public abstract class A2CardGame {
  protected A2Player[] player;   // card game players
  protected A2Deck deck;	 // deck of cards of the game

  // constructor
  public A2CardGame(A2Player[] p, A2Deck deck) {
    this.player = p;
    this.deck = deck;
    A2Player.setDeck(deck);
  }

  // YOU HAVE TO IMPLEMENT THIS METHOD
  // distribute the cards in the deck to all players as evenly as possible
  public void distributeAllCards() {
	  int id = 0;
	  while (deck.isEmpty() == false){
		  player[id].addCard(deck.drawCard());
		  id = nextPlayer(id);
	  }
  }
  
  // identify the player id who has a certain card
  // return -1 if no player can be identified
  public int playerHasCard(Card c) {
	  for (int i = 0; i < player.length; i++){
		  if (player[i].hasCard(c))
			  return i;
    }
	  return -1;
  }

  // print the cards each player has
  public void printAllHands() {
    for (int i = 0; i < player.length; i++) {
      System.out.print("Player " + i + " : ");
      player[i].printHand();
    }
  }

  // return the id of the next player of Player id
  public int nextPlayer(int id) {
    return (id + 1) % player.length;
  }
  
  // method that simulates the game from the beginning to the end
  public abstract void playOneGame();
}
