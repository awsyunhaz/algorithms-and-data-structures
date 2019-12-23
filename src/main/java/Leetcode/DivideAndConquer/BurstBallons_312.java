package Leetcode.DivideAndConquer;

public class BurstBallons_312 {
    // Divide and conquer with memory cache
    // O(N^3)
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return divide(nums, 0, nums.length-1, dp);
    }

    public int divide(int[] nums, int start, int end, int[][] dp) {
        if (start > end) {
            return 0;
        }
        // Memory cache
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int max = 0;
        for (int i = start; i <= end; i++) {
            int left = start == 0? 1: nums[start-1];
            int right = end == nums.length-1? 1: nums[end+1];
            // Bottom up - nums[i] is the last to burst
            max = Math.max(divide(nums, start, i-1, dp) + left*nums[i]*right +
                    divide(nums, i+1, end, dp), max);
        }
        dp[start][end] = max;
        return max;
    }

    // DP O(n^3)
//    public int maxCoins(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        // max coins from i to j
//        int[][] dp = new int[nums.length][nums.length];
//        for (int k = 0; k < nums.length; k++) {
//            for (int left = 0; left+k < nums.length; left++) {
//                int right = left + k;
//                for (int i = left; i <= right; i++) {
//                    int numLeft = left == 0? 1: nums[left-1];
//                    int numRight = right == nums.length-1? 1: nums[right+1];
//                    int coinsLeft = i == 0? 0: dp[left][i-1];
//                    int coinsRight = i == nums.length-1? 0: dp[i+1][right];
//                    dp[left][right] = Math.max(dp[left][right],
//                            coinsLeft + coinsRight + numLeft*numRight*nums[i]);
//                }
//            }
//        }
//        return dp[0][nums.length-1];
//    }
}
