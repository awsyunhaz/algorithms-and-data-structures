//DP-ÌøÊ¯°å

import java.util.*;

public class Jump{
   
  public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      
      int f[] = new int[m+1];
      for (int i = n; i <= m; i++){
      	f[i] = Integer.MAX_VALUE;
      }
      f[n] = 0;
       
      for (int i = n; i <= m; i++){
    	  if (f[i] == Integer.MAX_VALUE)
    		  continue;
    	  else{
    		  ArrayList<Integer> list = factor(i);
    		  for (int j = 0; j < list.size(); j++){
          		  int x = list.get(j);
          		  if (i+x <= m)
          			  f[i+x] = Math.min(f[i+x], f[i]+1);
          	  }  
    	  }
      }
      
      if (f[m] == Integer.MAX_VALUE)
    	  System.out.println(-1);
      else
    	  System.out.println(f[m]);
  }
      
  public static ArrayList<Integer> factor(int n){
  	ArrayList<Integer> temp = new ArrayList<Integer>();
  	for(int i = 2; i <= Math.sqrt(n); i++){
  		if (n%i == 0){
  			temp.add(i);
  			if (i != n/i)
  				temp.add(n/i);
  		}
  	}
  	return temp;
  }
}

