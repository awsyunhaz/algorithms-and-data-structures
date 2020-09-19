package Leetcode.DynamicProgramming;

public class WildcardMatching_44 {

    // Search, O(N^N) - TLE
//    public boolean isMatch(String s, String p) {
//        return isMatch(s, p, 0, 0);
//    }
//
//    public boolean isMatch(String s, String p, int sind, int pind) {
//        if (sind == s.length() && pind == p.length()) {
//            return true;
//        }
//        if (sind == s.length()) {
//            // remaining chars in p are all stars
//            return p.charAt(pind) == '*' && isMatch(s, p, sind, pind+1);
//        }
//        if (pind == p.length()) {
//            return false;
//        }
//        if (p.charAt(pind) == '*') {
//            // zero, one or more chars
//            return isMatch(s, p, sind+1, pind) || isMatch(s, p, sind, pind+1);
//        }
//        if (p.charAt(pind) == '?') {
//            return isMatch(s, p, sind+1, pind+1);
//        }
//        return s.charAt(sind) == p.charAt(pind) && isMatch(s, p, sind+1, pind+1);
//    }

    // Top-down search with memory, O(MN)
//    public boolean isMatch(String s, String p) {
//        Boolean[][] memory = new Boolean[s.length() + 1][p.length() + 1];
//        return isMatch(s, p, 0, 0, memory);
//    }
//
//    public boolean isMatch(String s, String p, int sind, int pind, Boolean[][] memory) {
//        if (memory[sind][pind] != null) {
//            return memory[sind][pind];
//        } else if (sind == s.length() && pind == p.length()) {
//            memory[sind][pind] = true;
//        } else if (sind == s.length()) {
//            // remaining chars in p are all stars
//            memory[sind][pind] = p.charAt(pind) == '*' && isMatch(s, p, sind, pind+1, memory);
//        } else if (pind == p.length()) {
//            memory[sind][pind] = false;
//        } else if (p.charAt(pind) == '*') {
//            // 0 or >= 1 char
//            memory[sind][pind] = isMatch(s, p, sind+1, pind, memory) || isMatch(s, p, sind, pind+1, memory);
//        } else if (p.charAt(pind) == '?') {
//            memory[sind][pind] = isMatch(s, p, sind+1, pind+1, memory);
//        } else {
//            memory[sind][pind] = s.charAt(sind) == p.charAt(pind) && isMatch(s, p, sind+1, pind+1, memory);
//        }
//        return memory[sind][pind];
//    }

    // DP - O(MN)
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = p.charAt(j-1) == '*' & dp[0][j-1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*') {
                    // 0 or >= 1 char
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = s.charAt(i-1) == p.charAt(j-1) && dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
