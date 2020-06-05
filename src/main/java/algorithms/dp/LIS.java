package algorithms.dp;

import java.util.Scanner;

public class LIS {
	
	private static final int MAX = 1000;
	private static int[][] a = new int[MAX+1][MAX+1];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] seq = new int[n];
		for (int i=0; i<n; i++){
			seq[i] = scanner.nextInt();
		}
		int[] dp = new int[n];  //�Ե�i����Ϊ�յ����������г���
		
		int maxLen = 0;
		for (int i=1; i<n; i++){
			dp[i] = 1;
			for (int j=i-1; j>=0; j--){
				if (seq[j]<seq[i])  //��ǰi-1�������У�Ѱ���յ�С��seq[i]�����������->������״̬  
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			maxLen = Math.max(dp[i], maxLen);
		}
		
		System.out.println(maxLen);
	}

}
