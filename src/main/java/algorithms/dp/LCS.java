package algorithms.dp;

import java.util.Scanner;

public class LCS {
	
	private static final int MAX = 1000;
	private static int[][] a = new int[MAX+1][MAX+1];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
			String s1 = scanner.nextLine();
			String s2 = new String();
			for (int i=s1.length()-1; i>=0; i--){
				s2 += s1.charAt(i);
			}
			
			System.out.println(s1.length()-maxLen(s1,s2));
	}
	
	public static int maxLen(String s1,String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		for (int i=0; i<len1; i++){
			a[i][0] = 0;
		}
		for (int i=0; i<len2; i++){
			a[0][i] = 0;
		}
		for (int i=1; i<=len1; i++){
			for (int j=1; j<=len2; j++){
				if (s1.charAt(i-1) == s2.charAt(j-1))
					a[i][j] = a[i-1][j-1]+1;
				else
					a[i][j] = Math.max(a[i-1][j],a[i][j-1]);
			}
		}
		return a[len1][len2];
		
	}
}
