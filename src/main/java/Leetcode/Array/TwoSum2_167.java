package Leetcode.Array;

public class TwoSum2_167 {
	
	public int[] twoSum2(int[] nums, int target){
		int low=0, high=nums.length-1;
		
		while(true){
			int sum = nums[low]+nums[high];
			if (low==high)
				throw new IllegalArgumentException();
			if (sum==target)
				return new int[] {low,high};
			if (sum>target)
				high--;
			if (sum<target)
				low++;
		}
	}
	
	public static void main(String[] args){
		TwoSum2_167 obj = new TwoSum2_167();
		System.out.println(obj.twoSum2(new int[]{2,7,9,11},9)[1]);
	}
}
