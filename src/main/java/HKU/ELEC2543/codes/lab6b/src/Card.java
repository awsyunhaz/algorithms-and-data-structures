public class Card {

  // define instance variables for the rank and suit of the card
	private Suit suit;
	private Rank rank;
 
  // define necessary constructor(s)
	public Card(Suit s, Rank r){
		suit = s;
		rank = r;
	}

  // define method public int compareTo(Card c)
  // the method returns -1 if the object is smaller than c
  // the method returns 0 if the object is the same as c
  // the method returns 1 if the object is larger than c
	public int compareTo(Card c){
		if (rank.ordinal() < c.rank.ordinal())
			return -1;
		if (rank.ordinal() > c.rank.ordinal())
			return 1;
		else{
			if (suit.ordinal() > c.suit.ordinal())
				return -1;
			else if (suit.ordinal() < c.suit.ordinal())
				return 1;
			else return 0;
		}
	}


  public String toString() {
    return suit.toString()+rank.toString();
  }
}
