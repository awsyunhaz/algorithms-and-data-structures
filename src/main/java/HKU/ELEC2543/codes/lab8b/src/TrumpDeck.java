import java.util.ArrayList;

public class TrumpDeck extends Deck{
	
	Suit trumpSuit;
	
	public TrumpDeck(Suit s){
		trumpSuit = s;
	}
	
	public int cardRank(Card card){
		if (card.getSuit() == trumpSuit)
			return 12 - card.getRank().ordinal() + 1;
		else if (card.getSuit().ordinal() < trumpSuit.ordinal())
		    return 13 + (12 - card.getRank().ordinal())*3 + card.getSuit().ordinal() + 1;
		else 
			return 13 + (12 - card.getRank().ordinal())*3 + card.getSuit().ordinal();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
}
