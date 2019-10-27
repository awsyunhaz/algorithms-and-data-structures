package Leetcode.DynamicProgramming;

public class HouseRobber2_213 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = f[0];
        for (int i = 2; i < nums.length-1; i++) {
            f[i] = Math.max(f[i-1], f[i-2] + nums[i]);
        }
        int tmp = f[nums.length-2];

        f[0] = 0;
        f[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            f[i] = Math.max(f[i-1], f[i-2] + nums[i]);
        }
        return Math.max(tmp, f[nums.length-1]);
    }
}
