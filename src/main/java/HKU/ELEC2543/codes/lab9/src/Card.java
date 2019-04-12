public class Card {

  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  public boolean equals(Card c) {
    return (this.rank == c.rank && this.suit == c.suit);
  }

  public boolean sameRankAs(Card c) {
    return (this.rank == c.rank);
  }

  public boolean sameSuitAs(Card c) {
    return (this.suit == c.suit);
  }

  public String toString() {
    return "" + suit + rank;
  }
}
