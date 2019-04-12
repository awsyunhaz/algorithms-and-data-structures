package assignment1;

public class Player {
	
	private int id;
	private int balance;
	private int position;
	private Path path;
	
	public Player(int x, int b, Path p){
		id = x;
		position = 0;
		balance = b;
		path = p;
	}
	
	public void move(){
		  
		int distance = (int)(Math.random()*6+1);
		
		position += distance;
		if (position > path.getSize()-1)
			position -= path.getSize();
	}
	
	public int getId(){
		return id;
	}
	
	public int getPosition(){
		return position;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public void addCash(int cash){
		balance += cash;
	}
	
	public boolean alive(){
		return (balance >= 0);
	}
	
	public void printStatus() {
	    for (int i = 0; i < position; i++) System.out.print(".");
	    System.out.print(id);
	    for (int i = position+1; i < path.getSize(); i++) System.out.print(".");
	    System.out.println("\tPlayer " + id + " has " + balance + " dollars.");
	}
	
}
