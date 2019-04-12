public class ERWPlayer {
  private int id;          // id of this player
  private int position;    // current position
  private int cash;	   // current cash amount
  private ERWPath path;    // the path the player is moving on

  public ERWPlayer(int id, int position, int cash, ERWPath path) {
    this.cash = cash;
    this.id = id;
    this.position = position;
    this.path = path;
  }

  public void move(int distance, int payCash)
  {
	  
	  position += distance;
	  if (position > path.getSize()-1){
		  position -= path.getSize();
		  if (position == 0)
			  cash += 100;
		  else
			  cash -= payCash; 
	  }
	  else 
		  cash -= payCash;
  }
  
  public int getPosition(){
	  return position;
  }
  
  public boolean alive(){
	  return (cash >= 0);
  }
  
  public void printStatus() {
    for (int i = 0; i < position; i++) System.out.print(".");
    System.out.print(id);
    for (int i = position+1; i < path.getSize(); i++) System.out.print(".");

    System.out.println("\tPlayer " + id + " has " + cash + " dollars.");
  }
}
