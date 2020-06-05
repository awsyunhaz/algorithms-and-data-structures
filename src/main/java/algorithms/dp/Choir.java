package algorithms.dp;

//DP-�ϳ���

import java.util.*;
 
public class Choir{
         
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int stu[] = new int[n+1];
        for (int i = 1; i <= n; i++){
        	stu[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        int fmax[][] = new int[k+1][n+1];
        int fmin[][] = new int[k+1][n+1];
        
        for (int i = 1; i <= k; i++){
        	for (int j = 1; j <= n; j++){
        		fmax[i][j] = 0;
        		fmin[i][j] = 0;
        	}
        }
        
        for (int i = 1; i <= n; i++){
        	fmax[1][i] = stu[i];
        	fmin[1][i] = stu[i];
        }
        
        for (int i = 2; i <= k; i++){
        	for (int j = 1; j <= n; j++){
        		for (int l = j-1; l>=j-d && l>=1; l--){
        			fmax[i][j] = Math.max(fmax[i][j], Math.max(fmax[i-1][l]*stu[j], fmin[i-1][l]*stu[j]));
        			fmin[i][j] = Math.min(fmin[i][j], Math.min(fmax[i-1][l]*stu[j], fmin[i-1][l]*stu[j]));
        		}
        	}
        }
        
        int max = 0;
        for (int j = 1; j <= n; j++){
        	if (fmax[k][j] > max)
        		max = fmax[k][j];
        }
        
        System.out.print(max);
    }
}
