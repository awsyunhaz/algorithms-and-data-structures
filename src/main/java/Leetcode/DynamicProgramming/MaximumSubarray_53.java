package Leetcode.DynamicProgramming;

public class MaximumSubarray_53 {
    // DP 1ms
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        int max = nums[0];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i-1] + nums[i], nums[i]);
//            f[i] = f[i-1] < 0? nums[i]: f[i-1] + nums[i];   - work the same
            if (f[i] > max)
                max = f[i];
        }
        return max;
    }

    // Greedy 1ms
//    public int maxSubArray(int[] nums) {
//        int sum = 0, max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++){
//            sum = Math.max(sum+nums[i], nums[i]);
//            if (sum>max)
//                max = sum;
//        }
//        return max;
//    }
}
