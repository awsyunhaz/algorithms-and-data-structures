import java.util.*;
 
public class Mod{
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int n = scanner.nextInt();
		char[] num = str.toCharArray();
		long mod[] = new long[n];
		long base = 1;
		mod[0] = 1;
		
		for (int i=num.length-1; i>=0; i--){
			if (num[i] == 'X'){
				long[] temp = new long[n]; 
				for (int j=0; j<=9; j++){
					int x = (int)((j*base)%n);
					for (int k=0; k<n; k++)
						temp[(k+x)%n] += mod[k];
				}
				mod = temp;
			}
			else{
				int x = (int)(((num[i]-'0')*base)%n);
				long[] temp = new long[n];
				for (int j=0; j<n; j++)
					temp[(j+x)%n] = mod[j];
				mod = temp;
			}
			base*=10;
		}
		
		System.out.println(mod[0]);
	}
	
}