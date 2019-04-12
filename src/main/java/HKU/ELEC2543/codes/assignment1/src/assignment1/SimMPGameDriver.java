package assignment1;

public class SimMPGameDriver {
	
	public static void main(String[] args)
	{
		int size = 12;
		int num = 4;
		int cash = 800;
		System.out.println("java SimMPGameDriver " + size + " " + num + " " + cash + "\n");
		
		SimMP game = new SimMP(size,num,cash);
		game.play();
	}

}
