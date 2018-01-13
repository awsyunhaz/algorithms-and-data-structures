package sort;

import java.util.Scanner;

public class QuickSort {
	
	public static void main(String[] args){
		int a[];
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		a = new int[n];
		
		for (int i = 0; i < n; i++){
			a[i] = scanner.nextInt();
		}
		
		sort(a,0,n-1);
		print(a);
	}
	
	public static void sort(int[] a,int low,int high){
		if (low < high){
			int mid = getMid(a,low,high);
			sort(a,0,mid-1);
			sort(a,mid+1,high);
		}
	}
	
	public static int getMid(int[] a,int low,int high){
		int key = a[low];
		while (low<high){
			while (low < high && a[high] >= key)
				high--;
			a[low] = a[high];
			while (low < high && a[low] <= key)
				low++;
			a[high] = a[low];
		}
		a[low] = key;  //low=high
		return low;
	}
	
	public static void print(int a[]){  
        for(int i=0; i<a.length; i++){  
            System.out.print(a[i]+" ");  
        }  
        System.out.println("");
    } 
}
