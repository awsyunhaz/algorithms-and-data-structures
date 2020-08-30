package Leetcode.DynamicProgramming;

public class CombinationSum4_377 {

    // backtrack O(l^n), l: nums length, n: target
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += combinationSum4(nums, target - nums[i]);
        }
        return res;
    }
}
