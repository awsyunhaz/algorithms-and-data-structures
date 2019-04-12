import java.util.ArrayList;

public class Player {
	
	ArrayList <Card> handCards = new ArrayList <Card>();
	int id;
	
	public Player(int x)
	{
		id = x;
	}
	
	public void addCard(Card c)
	{
		handCards.add(c);
	}
	
	public Card drawCard()
	{
		int size = handCards.size();
		int x = (int)(Math.random()*size);
		return handCards.remove(x);
	}
	
	public void printHand()
	{
		System.out.println("Player " + id + " has cards " + handCards);
	}
}
