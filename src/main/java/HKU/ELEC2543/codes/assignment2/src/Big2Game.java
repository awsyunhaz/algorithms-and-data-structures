// Provide necessary methods/method defintions for this class

public class Big2Game extends A2CardGame {

  // constructor
  public Big2Game(Big2Player[] p) {
	  super(p,new Big2Deck());
  }
  
  // the skeleton is provided
  // please put in the details
  
  public void playOneGame() {

    distributeAllCards(); // distribute the whole deck among players

    // identify the first player, the player who has D3

    Card currentCard = new Card(Rank.THREE, Suit.DIAMOND);
    Card lastCard = null;
    int currentPlayer = playerHasCard(currentCard);
    int lastDealPlayer;

    boolean gameEnd = false;
    boolean roundEnd = false;
    int round = 1;

    while (!gameEnd) {
    	roundEnd = false;
		System.out.println("Round " + round + " :");
		printAllHands();
    	
		Card c = ((Big2Player) player[currentPlayer]).smallestCard();
        System.out.print("P" + currentPlayer + " plays " + c + "; ");
        player[currentPlayer].removeCard(c);
		if (player[currentPlayer].emptyHand()){
			System.out.println("\nPlayer " + currentPlayer + " has won!");
			gameEnd = true; roundEnd = true;
		}
		
        currentCard = c;
        lastDealPlayer = currentPlayer;
        currentPlayer = nextPlayer(currentPlayer);
    	
    	while(!roundEnd){
    		lastCard = currentCard;
    		currentCard = player[currentPlayer].dealCard(currentCard);
        
    		if (currentCard == null){
    			System.out.print("P" + currentPlayer + " plays PASS; ");
    			currentCard = lastCard;
    		}
    		else{
    			player[currentPlayer].removeCard(currentCard);
    			System.out.print("P" + currentPlayer + " plays " + currentCard + "; ");
    			if (player[currentPlayer].emptyHand()){
    				System.out.println("\nPlayer " + currentPlayer + " has won!");
    				gameEnd = true; roundEnd = true;
    			}
    			else
    				lastDealPlayer = currentPlayer;
    		}
    		
    		currentPlayer = nextPlayer(currentPlayer);
    		if (lastDealPlayer == currentPlayer && !gameEnd){
    			roundEnd = true;
    			System.out.println("\nPlayer " + currentPlayer + " plays the biggest card in this round.\n");
    		}
    	}
    	round++;
    }
  }
}
