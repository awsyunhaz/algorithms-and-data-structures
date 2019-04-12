import java.util.Scanner;

public class PrintTriangles {

    private static void printMenu() {
        System.out.println("This program prints a shape with a certain size of your choice.");
        System.out.println("You have to select the shape from one of the following:");
        System.out.println("0 -- right-angled triangle with the right angle in the lower left");
        System.out.println("1 -- right-angled triangle with the right angle in the upper left");
        System.out.println("2 -- right-angled triangle with the right angle in the lower right");
        System.out.println("3 -- a diamond");

        System.out.println("After selecting the shape, you will be asked to input the size of the shape. For triangles, the size is the width and height of the triangle. This size must not be larger than 15. For diamonds, the size tells the number of * on the longest row. The size must be an odd number not larger than 15.\n");
    }

    private static void printLLT(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++)
	            System.out.print("*");
            System.out.println();
        }
    }
  
    private static void printULT(int size) {
	    for (int i = size-1; i >= 0; i--) {
	        for (int j = 0; j <= i; j++)
		        System.out.print("*");
	        System.out.println();
	    }
    }

    private static void printLRT(int size) {
	    for (int i = 0; i < size; i++) {
	        for (int k = 0; k < size-i-1; k++)
	            System.out.print(' ');
	        for (int j = 0; j <= i; j++)
		        System.out.print("*");
	        System.out.println();
	    }
    }
    
    private static void printDiamond(int size) {
	    for (int i = 0; i < (size+1)/2; i++) {
	        for (int k = 0; k < (size-1)/2-i; k++)
	            System.out.print(' ');
	        for (int j = 0; j <= 2*i; j++)
		        System.out.print("*");
	        System.out.println();
	    }
	    for (int i = (size-3)/2; i>=0; i--) {
	        for (int k = 0; k < (size-1)/2-i; k++)
	            System.out.print(' ');
	        for (int j = 0; j <= 2*i; j++)
		        System.out.print("*");
	        System.out.println();
	    }
    }
  
  public static void main(String[] args) {
    int choice, size, type;     //type: 0-triangle; 1-diamond;
    boolean validSize = false;
    Scanner scan = new Scanner(System.in);

    printMenu();

    do{
      System.out.print("Enter the choice of your shape:");
      choice = scan.nextInt();
    }while (choice < 0 || choice > 3);

    if (choice >= 0 && choice <=2)
    	type = 0;
    else type = 1;
    
    do{
      System.out.print("Enter the size of your shape:");
      size = scan.nextInt();
      if (type == 0){
    	  if (size >= 0 && size <= 15) 
    		  validSize = true;
    	  }
      else if (size >= 0 && size <= 15 && size % 2 == 1)
    	  validSize = true;
    }while (validSize == false);

    
    switch (choice) {
      case 0: printLLT(size); break;
      case 1: printULT(size); break;
      case 2: printLRT(size); break;
      case 3: printDiamond(size); break;
    }
  }
}
