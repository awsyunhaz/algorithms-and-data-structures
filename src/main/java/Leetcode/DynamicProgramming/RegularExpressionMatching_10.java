package Leetcode.DynamicProgramming;

public class RegularExpressionMatching_10 {

    // Backtrack O(2^(S+P))
    // with memorization, O(SP)
//    public boolean isMatch(String s, String p) {
//        Boolean[][] mem = new Boolean[s.length()+1][p.length()+1];
//        isMatch(s, p, 0, 0, mem);
//        return mem[0][0];
//    }
//
//    public boolean isMatch(String s, String p, int i, int j, Boolean[][] mem) {
//        if (mem[i][j] != null) {
//            return mem[i][j];
//        }
//        if (j == p.length()) {
//            mem[i][j] = i == s.length();
//            return mem[i][j];
//        }
//
//        boolean firstMatch = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
//
//        if (j+1 < p.length() && p.charAt(j+1) == '*') {
//            // match for zero or one time
//            mem[i][j] = isMatch(s, p, i, j+2, mem) || (firstMatch && isMatch(s, p, i+1, j, mem));
//        } else {
//            mem[i][j] = firstMatch && isMatch(s, p, i+1, j+1, mem);
//        }
//        return mem[i][j];
//    }

    // DP - O(SP)
    // s[i] = p[j] || p[j] = '.' -> dp[i][j] = dp[i-1][j-1]
    // p[j] = '*' -> dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j], if s[i] = p[j-1] || p[j-1] = '.'
    //                          (0 time,        1 time,     multiple times)
    //                        = dp[i][j-2], if else (0 time)
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i+1] = dp[0][i-1];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                        dp[i+1][j+1] = dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
