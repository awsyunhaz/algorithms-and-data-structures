import java.util.*;

public class RandomWalkGameDriver {

  public static void main(String[] args) {

	  System.out.println("please input size:");
	  Scanner scan = new Scanner(System.in);
	  int size = scan.nextInt();
	  
    RandomWalkGame game = new RandomWalkGame(size);
    game.play();
    
  }
}
