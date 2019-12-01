package Leetcode.DynamicProgramming;

public class TargetSum_494 {

    // DFS - O(2^n), 366ms
//    public int findTargetSumWays(int[] nums, int S) {
//        return search(nums, 0, S);
//    }
//
//    public int search(int[] nums, int i, int target) {
//        if (i == nums.length) {
//            return target == 0? 1: 0;
//        }
//        return search(nums, i+1, target-nums[i]) + search(nums, i+1, target + nums[i]);
//    }

    // 2D DP - O(ln), 16ms
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        // Corner case
        if (Math.abs(S) > sum) {
            return 0;
        }
        int[][] dp = new int[nums.length][2*sum+1];
        dp[0][nums[0]+sum] = 1;
        dp[0][-nums[0]+sum] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (j+nums[i] <= sum)
                    dp[i][j+nums[i]+sum] += dp[i-1][j+sum];
                if (j-nums[i] >= -sum)
                    dp[i][j-nums[i]+sum] += dp[i-1][j+sum];
            }
        }
        if (Math.abs(S) > sum) {
            return 0;
        }
        return dp[nums.length-1][S+sum];
    }
}
