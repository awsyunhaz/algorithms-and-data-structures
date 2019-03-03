package leetcode.HashTable;

import java.util.HashMap;

//Hash map - Time: O(N), Space: O(N)
public class TwoSum_1 {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int i=0; i<nums.length; i++){
			if (map.get(target-nums[i])!=null)
				return new int[]{map.get(target-nums[i]), i};
			map.put(nums[i], i);
		}
		return null;
//		throw new IllegalArgumentException("No solution");
	}
	
	public static void main(String[] args){
		TwoSum_1 obj = new TwoSum_1();
		System.out.println(obj.twoSum(new int[]{2,7,9,11},9)[1]);
	}
}
