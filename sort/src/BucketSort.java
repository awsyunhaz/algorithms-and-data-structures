package sort;
import java.util.*;

public class BucketSort {
	
	public static void main(String[] args){
		
		int a[];
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		a = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++){
			a[i] = scanner.nextInt();
			if (a[i] > max)
				max = a[i];
			if (a[i] < min)
				min = a[i];
		}
		
		int bucketNum = (max - min) / a.length + 1;;  //桶数
		
		int bucket[][] = new int[bucketNum][a.length];
		int order[] = new int[bucketNum];	//记录每个桶内元素个数
		
		//将每个元素放入桶
		for (int i = 0; i < a.length; i++){
			int x = (a[i] - min) / (a.length);  
			bucket[x][order[x]] = a[i];	//放入第x个桶
			order[x]++;
		}
		
		//对每个桶进行排序
		for(int i = 0; i < bucketNum; i++){
	        sort(bucket[i],0,order[i]-1);
	    }
		
		print(bucket);
		
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
		while (low < high){
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
	
	public static void print(int[][] a){  
        for(int i=0; i<a.length; i++){
        	for(int j=0; j<a[i].length; j++)
        		if (a[i][j] != 0)
        			System.out.print(a[i][j]+" ");	
        }  
        System.out.println("");
    } 

}
