import java.util.Random;

public class RandomPlayer extends Player{
	
	public RandomPlayer(int x){
		super(x);
	}
	
	public Card drawCard(){
	    if (cards.size() == 0) return null;

	    Random generator = new Random();
	    int i = generator.nextInt(cards.size());

	    return cards.remove(i); 
	}
	
}
