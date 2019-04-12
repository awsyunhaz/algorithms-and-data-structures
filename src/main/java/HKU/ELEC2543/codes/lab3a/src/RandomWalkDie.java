public class RandomWalkDie
{
   private int max;  	   // maximum possible face value
   private int faceValue;  // current value showing on the die
   
   public RandomWalkDie(int m){
	   
	   max = m;
	   
   }
   
   public int roll(){
	   
	   faceValue = (int)(Math.random()*max)+1;    //roll the dice
	   
	   return faceValue;
   }
   
   public int players(){
		
	   return ((int)(Math.random()*2)+1);    //select the player to move
	   
   }
   
   public int direction(){
	   
	   return ((int)(Math.random()*2)+1);    //select the direction to move
	   
   }
   
   
}
