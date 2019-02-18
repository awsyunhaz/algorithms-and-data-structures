package leetcode.DynamicProgramming;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        int max = nums[0];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            if (f[i] > max)
                max = f[i];
        }
        return max;
    }
}
