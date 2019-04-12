public class RandomWalkGame{

  private int size;
  private Player p1, p2;

  public RandomWalkGame(int s){
	  
	  size = s;
	  p1 = new Player(1);
	  p2 = new Player(size);
	  
  }
  
  // method to print the current locations of the two players
  private void printMap() {

    // the following variables are for keeping track of which player is on the left
    // and which is on the right
    Player leftPlayer, rightPlayer;	
    int leftPlayerID, rightPlayerID;

    // if both players are at the same position
    if (p1.getPosition() == p2.getPosition()) {
      for (int i = 1; i < p1.getPosition(); i++)
        System.out.print(".");

      System.out.print("X");

      for (int i = p1.getPosition()+1; i <= size; i++)
        System.out.print(".");

      return;
    }

    // if p1 is to the left of p2
    if (p1.getPosition() < p2.getPosition()) {
      leftPlayer = p1;
      rightPlayer = p2;
      leftPlayerID = 1;
      rightPlayerID = 2;
    }
    else {
    // if p2 is to the left of p1
      rightPlayer = p1;
      leftPlayer = p2;
      rightPlayerID = 1;
      leftPlayerID = 2;
    }

    // print out the map
    for (int i = 1; i < leftPlayer.getPosition(); i++) 
      System.out.print(".");

    System.out.print(leftPlayerID);

    for (int i = leftPlayer.getPosition()+1; i < rightPlayer.getPosition(); i++) 
      System.out.print(".");
    
    System.out.print(rightPlayerID);

    for (int i = rightPlayer.getPosition()+1; i <= size; i++) 
      System.out.print(".");
  }
  
  private void printMessage(Player p, int dir, int dis){
	  
	  String player, direction;
	  
	  if (p == p1) 
		  player = "1";
	  else
		  player = "2";
	  
	  if (dir == 1)
		  direction = "left";
	  else
		  direction = "right";
	
	  System.out.println("    [Player " + player + " moves to " + direction + " by " + dis + " unit(s)]");
	  
  }
  
  private boolean validation(Player p, int dir, int dis){
	  
	  if (dir == 1){
		  if (p.getPosition()-dis >=  1)
			  return true;
		  else 
			  return false;
	  }
	  else{
		  if (p.getPosition()+dis <= size)
			  return true;
		  else
			  return false;
	  }
  }

  public void play() {

// uncomment the do-while loop for testing
	RandomWalkDie p = new RandomWalkDie(3);    //selecting players and directions
	RandomWalkDie d = new RandomWalkDie(3);    //selecting distance 
	
	int dir, dis;
	
    do {
      printMap();
	   
	  if (p.players() == 1){
		  do{
			  dir = p.direction();
			  dis = d.roll();
		  }while(validation(p1, dir, dis) == false);    //keep rolling until the move is valid
		  p1.move(dir,dis);
	      printMessage(p1,dir,dis);
	  }
	  else{
		  do{
			  dir = p.direction();
			  dis = d.roll();
		  }while(validation(p2, dir, dis) == false);
		  p2.move(dir,dis);
	      printMessage(p2,dir,dis);
	  }

 //     p2.setPosition(p1.getPosition());

    } while (p1.getPosition() != p2.getPosition());

    System.out.println("Player 1 and Player 2 meet each other at position " + p1.getPosition());

  }
  
  private Player findPlayer(){
	  
	  int x = (int)(Math.random())+1;
	  if (x == 1)
		  return p1;
	  else 
		  return p2;
  }
}
