//DFS-¹¤×÷°²ÅÅ
import java.util.*;

public class Engineer{
       
	private static int sum = 0;
	private static int n;
	
  public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		ArrayList<Integer>[] engineers = new ArrayList[n];
		
		for (int i = 0; i < n; i++){
			String str = scanner.next();
			engineers[i] = new ArrayList<Integer>();
			for (int j = 0; j < str.length(); j++){
				engineers[i].add(str.charAt(j)-'0');
			}
		}
		boolean[] jobs = new boolean[6];
		dfs(engineers, jobs, 0);
		
		System.out.println(sum);
		
  }
  
  public static void dfs(ArrayList<Integer>[] engineers, boolean jobs[], int index){
  	if (index == n)
  		sum++;
  	else{
  		for (int job: engineers[index]){
  			if (jobs[job] == false){
  				jobs[job] = true;
  				dfs(engineers, jobs, index+1);
  				jobs[job] = false;
  			}
  		}
  	}
  }
		
}