package Leetcode.DynamicProgramming;

public class WildcardMatching_44 {

    // Search - TLE
//    public boolean isMatch(String s, String p) {
//        return match(s, p, 0, 0);
//    }
//
//    public boolean match(String s, String p, int si, int pi) {
//        if (pi == p.length()) {
//            return si == s.length();
//        }
//        if (si == s.length()) {
//            for (int i = pi; i < p.length(); i++) {
//                if (p.charAt(i) != '*') {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        if (p.charAt(pi) == '*') {
//            if (pi+1 < p.length() && p.charAt(pi+1)=='*')
//                return match(s, p, si, pi+1);
//            return match(s, p, si, pi+1) || match(s, p, si+1, pi);
//        } else {
//            if (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi)) {
//                return match(s, p, si+1, pi+1);
//            } else {
//                return false;
//            }
//        }
//    }

    // DP - O(ST)
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i+1] = dp[0][i];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i+1][j+1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
