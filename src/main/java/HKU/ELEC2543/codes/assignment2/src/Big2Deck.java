
public class Big2Deck extends A2Deck{
	
	public int cardRank(Card card) {
		if (card.getRank() == Rank.TWO)
			return card.getSuit().ordinal() + 1;
		else 
			return 5 + (12 - card.getRank().ordinal())*4 + card.getSuit().ordinal();
	}
}
