package Leetcode.DynamicProgramming;

public class LongestPalindromicSubstring_5 {
    // DP: O(n^2), space: O(n^2)
//    public String longestPalindrome(String s) {
//        boolean[][] f = new boolean[s.length()][s.length()];
//        int max = -1, start = 0, end = 0;
//            for (int i = s.length() - 1; i >= 0 ; i--) {
//            for (int j = i; j < s.length(); j++) {
//                if (i == j || (i+1 == j || f[i+1][j-1]) && s.charAt(i) == s.charAt(j)) {
//                    f[i][j] = true;
//                    if (j-i+1 > max) {
//                        max = j-i+1;
//                        start = i;
//                        end = j+1;
//                    }
//                }
//            }
//        }
//        return s.substring(start, end);
//    }

    // Extend around center
    // Time: O(n^2), space: constant
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = extend(s, i, i);
            String str2 = extend(s, i, i+1);
            String str = str1.length() >= str2.length()? str1: str2;
            res = str.length() > res.length()? str: res;
        }
        return res;
    }

    public String extend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i --;
            j ++;
        }
        return s.substring(i+1, j);
    }
}
