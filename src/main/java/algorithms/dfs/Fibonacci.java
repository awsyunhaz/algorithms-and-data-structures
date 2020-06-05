package algorithms.dfs;

import java.util.*;

public class Fibonacci {
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(fibonacci(n));
	}
	
	public static int fibonacci(int n){
		if (n == 1)
			return 1;
		else if (n == 2)
			return 1;
		else return fibonacci(n-2)+fibonacci(n-1);
		
	}

}
