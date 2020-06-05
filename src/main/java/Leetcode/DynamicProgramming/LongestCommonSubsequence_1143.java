package Leetcode.DynamicProgramming;

public class LongestCommonSubsequence_1143 {

    // backtrack (top-down), O(2^(m+n)), TLE
//    public int longestCommonSubsequence(String text1, String text2) {
//        return lcs(text1, text2, 0, 0);
//    }
//
//    public int lcs(String text1, String text2, int i, int j) {
//        if (i >= text1.length() || j >= text2.length()) {
//            return 0;
//        }
//        if (text1.charAt(i) == text2.charAt(j)) {
//            return 1 + lcs(text1, text2, i+1, j+1);
//        } else {
//            return Math.max(lcs(text1, text2, i+1, j), lcs(text1, text2, i, j+1));
//        }
//    }

    // backtrack with memorization (top-down), O(m*n), 24ms
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] memory = new int[text1.length()][text2.length()];
//        return lcs(text1, text2, 0, 0, memory);
//    }
//
//    public int lcs(String text1, String text2, int i, int j, int[][] memory) {
//        if (i >= text1.length() || j >= text2.length()) {
//            return 0;
//        }
//        // lcs of text1.substring(i) and text2.substring(j)
//        if (memory[i][j] > 0) {
//            return memory[i][j];
//        }
//        if (text1.charAt(i) == text2.charAt(j)) {
//            return 1 + lcs(text1, text2, i+1, j+1, memory);
//        } else {
//            memory[i][j] = Math.max(lcs(text1, text2, i+1, j, memory), lcs(text1, text2, i, j+1, memory));
//            return memory[i][j];
//        }
//    }

    // DP (bottom up), O(m*n), 9ms
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    // Space optimization: space O(n)
//    public int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length(), n = text2.length();
//        int[] dp = new int[n+1];
//        for (int i = 1; i <= m; i++) {
//            int[] memory = new int[n+1];
//            for (int j = 1; j <= n; j++) {
//                if (text1.charAt(i-1) == text2.charAt(j-1)) {
//                    // dp[i-1][j-1]
//                    memory[j] = dp[j-1] + 1;
//                } else {
//                    // dp[i-1][j], dp[i][j-1]
//                    memory[j] = Math.max(dp[j], memory[j-1]);
//                }
//            }
//            dp = memory;
//        }
//        return dp[n];
//    }
}
