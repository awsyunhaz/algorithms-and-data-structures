import java.util.Scanner;

public class Hanoi {

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		hanoi(n,1,2,3);
	}
	
	public static void hanoi(int n, int a, int b, int c){
		if (n == 1)
			System.out.println(a + "->" + c);
		else{ 
			hanoi(n-1,a,c,b);
			System.out.println(a + "->" + c);
			hanoi(n-1,b,a,c);
		}
	}

}
