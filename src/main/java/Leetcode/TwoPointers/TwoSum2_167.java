package Leetcode.TwoPointers;

public class TwoSum2_167 {

	public int[] twoSum(int[] numbers, int target) {
		int lo = 0, hi = numbers.length - 1;
		while (lo <= hi) {
			int sum = numbers[lo] + numbers[hi];
			if (sum == target) {
				return new int[]{lo+1, hi+1};
			} else if (sum < target) {
				lo ++;
			} else {
				hi --;
			}
		}
		return new int[]{};
	}
	
	public static void main(String[] args){
		TwoSum2_167 obj = new TwoSum2_167();
		System.out.println(obj.twoSum(new int[]{2,7,9,11},9)[1]);
	}
}
