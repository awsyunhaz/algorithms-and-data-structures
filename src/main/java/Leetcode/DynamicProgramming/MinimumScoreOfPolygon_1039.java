package Leetcode.DynamicProgramming;

public class MinimumScoreOfPolygon_1039 {
    public int minScoreTriangulation(int[] A) {
        // dp[i][j] = dp[left][i] + A[left]*A[i]*A[right] + dp[i][right]
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][len];
        for (int k = 2; k < len; k++) {
            for (int left = 0; left+k < len; left++) {
                int right = left + k;
                dp[left][right] = Integer.MAX_VALUE;
                for (int i = left+1; i < right; i++) {
                    dp[left][right] = Math.min(dp[left][right],
                            dp[left][i] + dp[i][right] + A[left]*A[i]*A[right]);
                }
            }
        }
        return dp[0][len-1];
    }
}
