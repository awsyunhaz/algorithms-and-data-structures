// You can define instance variables and methods as needed

public class Lab9CardGame {
  private Lab9Player[] player;
  private Deck deck;

  public Lab9CardGame(Lab9Player[] p) {
    this.player = p;
    this.deck = new Deck();
    Lab9Player.setDeck(deck);
  }

  // IMPLEMENT THIS METHOD
  // distribute the cards in the deck to all players evenly
  public void distributeAllCards() {
	  int id = 0;
	  while (deck.isEmpty() == false){
		  player[id].addCard(deck.drawCard());
		  id = nextPlayer(id);
	  }
  }

  // IMPLEMENT THIS METHOD
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

  // the skeleton is provided
  // implement this method
  public void playOneGame() {

    distributeAllCards();
    printAllHands();

    // identify the first player
    Card currentCard = new Card(Rank.TWO, Suit.DIAMOND);
    Card lastCard = null;
    int currentPlayer = playerHasCard(currentCard);

    boolean gameEnd = false;
    
    System.out.print("P" + currentPlayer + " plays D2; ");
    player[currentPlayer].removeCard(currentCard);
    currentPlayer = nextPlayer(currentPlayer);
    
    while (!gameEnd) {

      // currentCard = card dealt by the player by calling method dealCard(Object object)
      lastCard = currentCard;
      currentCard = player[currentPlayer].dealCard(currentCard);
      
      if (currentCard == null){
    	  System.out.print("P" + currentPlayer + " plays PASS; ");
    	  currentCard = lastCard;
      }
      else{
    	  player[currentPlayer].removeCard(currentCard);
    	  System.out.print("P" + currentPlayer + " plays " + currentCard + "; ");
    	  lastCard = currentCard;
      }
    	  
      // check whether the game ends
      if (currentCard.equals(new Card(Rank.ACE, Suit.SPADE))) {
    	  System.out.println("\nPlayer " + currentPlayer + " plays the biggest card.\n");
    	  gameEnd = true;
      }
            
      currentPlayer = nextPlayer(currentPlayer);
      
    }

    System.out.println("After the game:");
    printAllHands();
  }
}
