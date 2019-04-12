package assignment1;

public class Path {

	private int size;
	private int[] lotOwner;
	
	public Path(int s){
		size = s;
		lotOwner = new int[size];
		for (int i = 0; i < size; i++){
			lotOwner[i] = -1;
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public int getOwnerId(int x){
		return lotOwner[x];
	}
	
	public void buyLot(Player p, int x){
		lotOwner[x] = p.getId();
	}
	
	public void printOwnership(){
		for (int i = 0; i < size; i++){
			if (lotOwner[i] == -1)
				System.out.print(".");
			else
				System.out.print(lotOwner[i]);
		}
		System.out.println("\n");
	}
}
