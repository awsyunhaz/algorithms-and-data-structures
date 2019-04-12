import java.util.ArrayList;

public class SevensDeck extends A2Deck{
	
	//cards on the table, divided by its suit
	private ArrayList<Card> spade;
	private ArrayList<Card> heart;
	private ArrayList<Card> club;
	private ArrayList<Card> diamond;
	
	public SevensDeck(){
		spade = new ArrayList<Card>();
		heart = new ArrayList<Card>();
		club = new ArrayList<Card>();
		diamond = new ArrayList<Card>();
	}
	
	public int cardRank(Card card) {
		return (3-card.getSuit().ordinal())*13 + 13-(card.getRank().ordinal()+1)%13;
	}
	
	public void addCard(Card card){
		if (card.getSuit() == Suit.SPADE){
			if (spade.isEmpty())
				spade.add(card);
			else if (cardRank(card)==cardRank(spade.get(0))+1)
				spade.add(0,card);
			else
				spade.add(card);
		}
		else if (card.getSuit() == Suit.HEART){
			if (heart.isEmpty())
				heart.add(card);
			else if (cardRank(card)==cardRank(heart.get(0))+1)
				heart.add(0,card);
			else
				heart.add(card);
		}
		else if (card.getSuit() == Suit.CLUB){
			if (club.isEmpty())
				club.add(card);
			else if (cardRank(card)==cardRank(club.get(0))+1)
				club.add(0,card);
			else
				club.add(card);
		}
		else{
			if (diamond.isEmpty())
				diamond.add(card);
			else if (cardRank(card)==cardRank(diamond.get(0))+1)
				diamond.add(0,card);
			else
				diamond.add(card);
		}
	}
	
	public void printTable(){
		System.out.print("\n\nTable:  ");
		if (spade.size()==0)
			System.out.print("null ... null  ");
		else
			System.out.print(spade.get(0) + " ... " + spade.get(spade.size()-1) + "  ");
		if (heart.size()==0)
			System.out.print("null ... null  ");
		else
			System.out.print(heart.get(0) + " ... " + heart.get(heart.size()-1) + "  ");
		if (club.size()==0)
			System.out.print("null ... null  ");
		else
			System.out.print(club.get(0) + " ... " + club.get(club.size()-1) + "  ");
		if (diamond.size()==0)
			System.out.print("null ... null\n");
		else
			System.out.print(diamond.get(0) + " ... " + diamond.get(diamond.size()-1) + "\n");
	}
	
	public ArrayList<Card> getSpade(){
		return spade;
	}
	
	public ArrayList<Card> getHeart(){
		return heart;
	}
	
	public ArrayList<Card> getClub(){
		return club;
	}
	
	public ArrayList<Card> getDiamond(){
		return diamond;
	}
}