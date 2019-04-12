package assignment1;

public class SimMP {

	private Player[] players;
	private Path path;
	private int playersNum;
	
	public SimMP(int size, int num, int cash){
		playersNum = num;
		path = new Path(size);
		players = new Player[size];
		for (int i = 0; i < num; i++){
			players[i] = new Player(i,cash,path);
		}
	}
	
	private boolean allAlive(){
		for (int i = 0; i < playersNum; i++){
			if (players[i].alive() == false) 
				return false;
		}
		return true;
	}
	
	public void play()
	{
		for (int i = 0; i < playersNum; i++){
			players[i].printStatus();
		}
		path.printOwnership();
		
		int round = 1;
		do{
			System.out.println("Round " + round + ":");
			for (int i = 0; i < playersNum; i++){
				players[i].move();
				if (players[i].getPosition() == 0){
					players[i].addCash(100);
					System.out.println("Player " + i + " receives 100 dollars.");
				}
				else if (path.getOwnerId(players[i].getPosition()) == -1){
					int die = (int)(Math.random()*2);
					int price = (int)(Math.random()*5+1)*100;
					if (die == 0)
						System.out.println("Player " + i + " does not want to buy lot " + players[i].getPosition() + " with " + price + " dollars.");
					if (die == 1){
						if (players[i].getBalance() >= price){
							path.buyLot(players[i],players[i].getPosition());
							players[i].addCash(-price);
							System.out.println("Player " + i + " buys lot " + players[i].getPosition() + " with " + price + " dollars.");
						}
						else
							System.out.println("Player " + i + " does not have enough money to buy lot " + players[i].getPosition() + " with " + price + " dollars.");
					}
				}
				else if (path.getOwnerId(players[i].getPosition()) == i)
					System.out.println("Player " + i + " is now on his own lot.");
				else {
					int rent = (int)(Math.random()*10+1)*10;
					players[i].addCash(-rent);
					players[path.getOwnerId(players[i].getPosition())].addCash(rent);
					System.out.println("Player " + i + " pays " + rent + " dollars to Player " + path.getOwnerId(players[i].getPosition()) + " for lot " + players[i].getPosition() + ".");
				}
			  }
			
			for (int i = 0; i < playersNum; i++)
				players[i].printStatus();
			path.printOwnership();
			round ++;
			
		}while (round <= 20 && allAlive());
	}
}
