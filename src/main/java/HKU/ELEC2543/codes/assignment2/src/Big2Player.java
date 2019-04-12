import java.util.ArrayList;

public class Big2Player extends A2Player{
	
	public Card dealCard(Object card){
		int i = 0;
		do{
			if (deck.compareCards(cards.get(i), (Card)card) > 0)
				return cards.get(i);
			i++;
		}while(i<numCardsInHand());
		return null;
	};
	
	//remove the smallest card in hand
	public Card smallestCard(){
		return cards.get(0);
	}
}
