package Leetcode.DynamicProgramming;

public class NumberOfLongestIncreasingSubsequences_673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int maxLen = 0, maxCnt = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxCnt = cnt[i];
            } else if (dp[i] == maxLen) {
                maxCnt += cnt[i];
            }
        }
        return maxCnt;
    }
}
