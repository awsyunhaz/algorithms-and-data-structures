public class CheatPlayer extends Player{
	
	public CheatPlayer(int x){
		super(x);
	}
	
	public Card drawCard(){
		Card cardDeal = cards.get(0);
		for (Card c: cards){
			if (deck.cardRank(c) < deck.cardRank(cardDeal))
				cardDeal = c;
		}
		cards.remove(cardDeal);
		return cardDeal;
	}
	
	public void cheat(){
		Card cardSwap = cards.get(0);
		for (Card c: cards){
			if (deck.cardRank(c) > deck.cardRank(cardSwap))
				cardSwap = c;
		}
		cards.remove(cardSwap);
		cards.add(deck.drawCard());
		((TrumpDeck)deck).addCard(cardSwap);
	}
	
}