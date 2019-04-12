import java.util.ArrayList;

public class SevensPlayer extends A2Player{
	
	public Card dealCard(Object sequence){
		int i = 0;
		do{
			Card c = cards.get(i); 
			if (c.getSuit() == Suit.SPADE){
				ArrayList<Card> spade = ((SevensDeck)sequence).getSpade();
				if (spade.isEmpty()){
					if (c.getRank()==Rank.SEVEN)
						return c;
				}
				else if (deck.cardRank(c)==deck.cardRank(spade.get(0))+1 || deck.cardRank(c)==deck.cardRank(spade.get(spade.size()-1))-1)
					return c;
			}
			else if (c.getSuit() == Suit.HEART){
				ArrayList<Card> heart = ((SevensDeck)sequence).getHeart();
				if (heart.isEmpty()){
					if (c.getRank()==Rank.SEVEN)
						return c;
				}
				else if (deck.cardRank(c)==deck.cardRank(heart.get(0))+1 || deck.cardRank(c)==deck.cardRank(heart.get(heart.size()-1))-1)
					return c;
			}
			else if (c.getSuit() == Suit.CLUB){
				ArrayList<Card> club = ((SevensDeck)sequence).getClub();
				if (club.isEmpty()){
					if (c.getRank()==Rank.SEVEN)
						return c;
				}
				else if (deck.cardRank(c)==deck.cardRank(club.get(0))+1 || deck.cardRank(c)==deck.cardRank(club.get(club.size()-1))-1)
					return c;
			}
			else{
				ArrayList<Card> diamond = ((SevensDeck)sequence).getDiamond();
				if (diamond.isEmpty()){
					if (c.getRank()==Rank.SEVEN)
						return c;
				}
				else if (deck.cardRank(c)==deck.cardRank(diamond.get(0))+1 || deck.cardRank(c)==deck.cardRank(diamond.get(diamond.size()-1))-1)
					return c;
			}
			i++;
		}while(i<numCardsInHand());
		
		return null;
	};
	
}
