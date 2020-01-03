package Leetcode.Array;

public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0];
        int res = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(max*nums[i], nums[i]);
                min = Math.min(min*nums[i], nums[i]);
            } else {
                int tmp = max;
                max = Math.max(min*nums[i], nums[i]);
                min = Math.min(tmp*nums[i], nums[i]);
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
