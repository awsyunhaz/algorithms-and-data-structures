package sort;

import java.util.Scanner;

public class ShellSort {
	
	public static void main(String[] args){
		int a[];
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		a = new int[n];
		
		for (int i = 0; i < n; i++){
			a[i] = scanner.nextInt();
		}
		
		sort(a);
		print(a);
	}
	
	private static void sort(int[] a){
		int d = a.length/2;
		while (d >= 1){
			insertSort(a,d);	//增量d
			d /= 2;
		}
	}
	
	private static void insertSort(int[] a, int d){
		for (int i = d; i < a.length; i++){
			if (a[i] < a[i-d]){
				int x = a[i];
				a[i] = a[i-d];
				int j;
				for (j = i-d; j>=0 && x<a[j]; j-=d) //逐个后移找到要插入的位置
					a[j+d] = a[j];
				a[j+d] = x;
			}
		}
	}
	
	public static void print(int a[]){  
        for(int i=0;i<a.length;i++){  
            System.out.print(a[i]+" ");  
        }  
        System.out.println("");
    }  
}
