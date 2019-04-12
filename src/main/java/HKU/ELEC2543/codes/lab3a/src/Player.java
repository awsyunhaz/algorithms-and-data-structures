public class Player {
	
	private int currentPos;
	
	public Player(int initialPos){
		
		currentPos = initialPos;
		
	}

  // getter method for the position of the player
  // you have to use the method name
  // revise the return statement
  public int getPosition() {
	  
    return currentPos;
    
  }
  
  public void setPosition(int p){
	  
	  currentPos = p;
	  
  }
  
  public void move(int dir, int dis){
	  
	  if (dir == 1)
		  setPosition(getPosition()-dis);
	  else
		  setPosition(getPosition()+dis);
	  
  }

}
