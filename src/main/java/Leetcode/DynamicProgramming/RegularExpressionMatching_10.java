package Leetcode.DynamicProgramming;

public class RegularExpressionMatching_10 {

    // Backtrack O(2^(S+P))
//    public boolean isMatch(String s, String p) {
//        return match(s, p, 0, 0);
//    }
//
//    public boolean match(String s, String p, int si, int pi) {
//        if (pi == p.length()) {
//            return si == s.length();
//        }
//
//        // Whether the first characters match
//        boolean firstMatch = (si != s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.'));
//
//        if (p.length() > pi + 1 && p.charAt(pi+1) == '*') {
//            // Repeat 0 or 1 time
//            return match(s, p, si, pi+2) || (firstMatch && match(s, p, si+1, pi));
//        } else {
//            return firstMatch && match(s, p, si+1, pi+1);
//        }
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
