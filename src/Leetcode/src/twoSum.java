import java.util.HashMap;

public class twoSum {

	public int[] twoSum(int[] nums, int target){
		HashMap<Integer,Integer> map = new HashMap();
		
		for (int i=0; i<nums.length; i++){
			int complement = target-nums[i];
			if (map.containsKey(complement))
				return new int[] {map.get(complement)+1,i+1};
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No solution");
	}
	
	public static void main(String[] args){
		twoSum obj = new twoSum();
		System.out.println(obj.twoSum(new int[]{2,7,9,11},9)[1]);
	}
}
