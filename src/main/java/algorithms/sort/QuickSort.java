package algorithms.sort;

public class QuickSort {

	public static int partition(int[] arr, int lo, int hi){
		int pivot = arr[lo];
		while (lo < hi) {
			while (lo < hi && pivot <= arr[hi]) hi--;
			arr[lo] = arr[hi];
			while (lo < hi && arr[lo] < pivot) lo++;
			arr[hi] = arr[lo];
		}
		arr[lo] = pivot;
		return lo;
	}

	public static void sort(int[] arr, int lo, int hi){
		if (lo < hi) {
			int mid = partition(arr, lo, hi);
			sort(arr, 0, mid - 1);
			sort(arr, mid + 1, hi);
		}
	}

	public static void main(String[] args){
		int[] arr = new int[]{5,2,4,3,7,6,1};
		sort(arr, 0, arr.length-1);
		for (int num: arr){
			System.out.print(num);
		}
	}
}
