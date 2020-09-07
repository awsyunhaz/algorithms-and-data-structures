package Leetcode.DynamicProgramming;

public class DistinctSubsequences_115 {
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] f = new int[m+1][n+1];
        for (int j = 0; j <= n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                // do not take the last char in s
                f[i][j] = f[i][j-1];
                // take the last char in s
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    f[i][j] += f[i-1][j-1];
                }
            }
        }
        return f[m][n];
    }
}
