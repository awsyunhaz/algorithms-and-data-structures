// Provide necessary methods/method defintions for this class
import java.util.ArrayList;

public class SevensGame extends A2CardGame {
  
	private SevensDeck sequence;
	
  // constructor
  public SevensGame(SevensPlayer[] p) {
	  super(p,new SevensDeck());
	  sequence = new SevensDeck();

  }
  
  // the skeleton is provided
  // please put in the details
  
  public void playOneGame() {

    distributeAllCards(); // distribute the whole deck among players

    // identify the first player, the player who has D3

    Card currentCard = new Card(Rank.SEVEN, Suit.HEART);
    int currentPlayer = playerHasCard(currentCard);
    boolean gameEnd = false;
    int cardsInARound = 0;
    
	printAllHands();
    System.out.println("P" + currentPlayer + " plays " + currentCard + ";");
    player[currentPlayer].removeCard(currentCard);
	sequence.addCard(currentCard);
    currentPlayer = nextPlayer(currentPlayer);

    while (!gameEnd) {
     	cardsInARound = 0;
    	sequence.printTable();
		printAllHands();
		while(cardsInARound < 6){
    		currentCard = player[currentPlayer].dealCard(sequence);
    		if (currentCard == null){
    			System.out.print("P" + currentPlayer + " plays PASS; ");
    		}
    		else{
    			player[currentPlayer].removeCard(currentCard);
    			sequence.addCard(currentCard);
    			System.out.print("P" + currentPlayer + " plays " + currentCard + "; ");
    			cardsInARound++;
    			if (player[currentPlayer].emptyHand()){
    				System.out.println("\nPlayer " + currentPlayer + " has won!");
    				gameEnd = true; cardsInARound = 6;
    			}
    		
    		}
    	currentPlayer = nextPlayer(currentPlayer);
		}
    }
  }
  
}
