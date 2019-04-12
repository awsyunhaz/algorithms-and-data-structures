import java.io.*;

public class PlayCard {

  // shuffle the array elements in cards
  // there are many different ways to shuffle the cards
  // as long as the arrangement of the deck looks random,
  // it is fine
  public static void shuffle(Card[] cards,int length) {
	  final int TIMES = 20;		//shuffle times
	  Card c = new Card(Suit.SPADE, Rank.TWO);
	  
	  for (int i = 1; i <= TIMES; i++)
	  {
		  int x1 = (int)(Math.random()*length);
		  int x2 = (int)(Math.random()*length);
		  
		  //exchange the two cards randomly selected
		  c = cards[x1];
		  cards[x1] = cards[x2];
		  cards[x2] = c; 
	  }
  }

  public static void main(String[] args) throws IOException {

    Card cards[];  // array for the deck

    // print out the appropriate number of cards
    // DO NOT HARDCODE THE NUMBER

    int length = 0;
    for (Suit i : Suit.values())
    	for (Rank j : Rank.values())
    		length ++;
    System.out.println("Number of cards: " + length);

    // PUT A COPY OF EACH CARD IN THE ARRAY
    cards = new Card[length];
    
    int x = 0;
    for (Suit i : Suit.values())
    	for (Rank j : Rank.values())
    	{
    		cards[x] = new Card(i,j);
    		x++;
    	}
    
    // The following codes print out the whole array of cards
    // YOU DO NOT HAVE TO MODIFY THIS
    System.out.println("\nBefore shuffling:");
    for (Card c : cards) 
      System.out.print(c + " ");

    // IMPLEMENT THE shuffle METHOD
    shuffle(cards,length);

    // The following codes print out the whole array of cards
    // YOU DO NOT HAVE TO MODIFY THIS
    System.out.println("\n\nAfter shuffling:");
    for (Card c : cards) 
      System.out.print(c + " ");

    // randomly draw two cards and assign them to be c1 and c2
    // you do not have to remove the cards from the array
    Card c1, c2;
    int x1 = (int)(Math.random()*length);
    int x2 = (int)(Math.random()*length);
    
    c1 = cards[x1];
    c2 = cards[x2];

    System.out.println("\n\nTwo cards are drawn:");
    System.out.println("c1 = " + c1 + " and c2 = " + c2);

    // Determine which card is larger and print the result out
    if (c1.compareTo(c2) == -1)
    	System.out.println(c1 + " is smaller than " + c2);
    else if (c1.compareTo(c2) == 1)
    	System.out.println(c1 + " is larger than " + c2);
    else 
    	System.out.println(c1 + " is the same as " + c2);
  }
}
