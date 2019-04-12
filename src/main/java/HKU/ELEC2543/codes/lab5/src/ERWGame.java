public class ERWGame{

  private ERWPath path;         // the path 
  private ERWPlayer p0, p1, p2; // three players

  public ERWGame(int pathLength, int cash) {
    path = new ERWPath(pathLength);

    p0 = new ERWPlayer(0, 0, cash, path);
    p1 = new ERWPlayer(1, 0, cash, path);
    p2 = new ERWPlayer(2, 0, cash, path);
  }

  public void printAllStatus(){
	p0.printStatus();
	p1.printStatus();
	p2.printStatus();
	System.out.println();
  }
  
  public void play() {

	System.out.println("Beginning of Game ....");
	printAllStatus();
	
	RandomDie die1 = new RandomDie(6);
	RandomDie die2 = new RandomDie(10);
	int round = 1;
    
	do {
		System.out.println("Round " + round + ":");
		
		int distance = die1.roll();
		int payCash = die2.roll()*10;
    	p0.move(distance, payCash);
    	if (p0.getPosition() == 0)
    		System.out.println("Player 0 gets 100 dollars.");
    	else
    		System.out.println("Player 0 pays " + payCash + " dollars.");
    	
    	// each player makes a move
		distance = die1.roll();
		payCash = die2.roll()*10;
    	p1.move(distance, payCash);
    	if (p1.getPosition() == 0)
    		System.out.println("Player 1 gets 100 dollars.");
    	else
    		System.out.println("Player 1 pays " + payCash + " dollars.");
    	
		distance = die1.roll();
		payCash = die2.roll()*10;
		p2.move(distance, payCash);
    	if (p2.getPosition() == 0)
    		System.out.println("Player 2 gets 100 dollars.");
    	else
    		System.out.println("Player 2 pays " + payCash + " dollars.");
    	
    	printAllStatus();
    	round ++;

    } while (p0.alive() && p1.alive() && p2.alive());

  }
}

