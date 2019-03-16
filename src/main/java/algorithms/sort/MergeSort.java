package algorithms.sort;

import java.util.Scanner;

public class MergeSort {
	
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
		int mid = (low+high)/2;
		if (low < high){
			sort(a,low,mid);
			sort(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	
	public static void merge(int[] a,int low,int mid,int high){
		int[] temp = new int[high-low+1];
		int i = low;
		int j = mid+1;
		int k = 0;
		
		// �ѽ�С�������Ƶ��������� 
		while (i <= mid && j <= high){
			if (a[i] < a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		
		// �����ʣ������������� 
		while (i <= mid){
			temp[k++] = a[i++];
		}
		
		// ���ұ߱�ʣ������������� 
		while (j <= high){
			temp[k++] = a[j++];
		}
		
		for (i = 0; i < temp.length; i++){
			a[low+i] = temp[i];
		}
	}

	public static void print(int a[]){  
        for(int i=0;i<a.length;i++){  
            System.out.print(a[i]+" ");  
        }  
        System.out.println("");
	}
}
