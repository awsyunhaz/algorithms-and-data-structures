import java.util.ArrayList;

public class CardGame {
	
	private int round;
	Player p1,p2;
	ArrayList <Card> deck = new ArrayList <Card>();
	
	public CardGame(int k)
	{
		round = k;
		p1 = new Player(1);
		p2 = new Player(2);
	    
	}
	
	public void play()
	{
		int len = 0;
	    for (Suit i : Suit.values())
	    	for (Rank j : Rank.values())
	    	{
	    		deck.add(new Card(i,j));
	    		len++;
	    	}
	    
		for (int i = 0; i < round; i++)
		{
			int x = (int)(Math.random()*len);
				p1.addCard(deck.get(x));
				deck.remove(x);
				len--;
			
			x = (int)(Math.random()*len);
				p2.addCard(deck.get(x));
				deck.remove(x);
				len--;
		}
		
		for (int i = 0; i < round; i++)
		{
			p1.printHand();
			p2.printHand();
			
			Card c1 = p1.drawCard();
			Card c2 = p2.drawCard();
			System.out.println("Player 1 deals " + c1);
			System.out.println("Player 2 deals " + c2);
		    
			if (c1.compareTo(c2) == -1)
		    	System.out.println("Player 2 wins in this round!\n");
		    else if (c1.compareTo(c2) == 1)
		    	System.out.println("Player 1 wins in this round!\n");
		}
		
	}
}
