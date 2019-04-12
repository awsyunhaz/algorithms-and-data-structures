public class RandomDie
{
   private int max=6;  
   private int faceValue;  // current value showing on the die

   //-----------------------------------------------------------------
   //  Constructor: Sets the initial face value.
   //-----------------------------------------------------------------
   public RandomDie(int maxFacevalue)
   {
      max = maxFacevalue;
   }

   //-----------------------------------------------------------------
   //  Rolls the die and returns the result.
   //-----------------------------------------------------------------
   public int roll()
   {
      faceValue = (int)(Math.random() * max) + 1;

      return faceValue;
   }
}
