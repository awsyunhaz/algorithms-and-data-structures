package Leetcode.DynamicProgramming;

//Time: O(n^2), space: O(n^2)
public class LongestPalindromicSubstring_5 {
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len == 0)
//            return s;
//        int[][] f = new int[len][len];
//        for (int i = 0; i < len; i++)
//            f[i][i] = 1;
//        int start = 0, end = 1, max = 1;
//        for (int i = len-1; i >= 0; i--){
//            for (int j = i+1; j < len; j++){
//                if (j == i+1 && s.charAt(i) == s.charAt(j)
//                        || f[i+1][j-1]==1 && s.charAt(i) == s.charAt(j)){
//                    f[i][j] = 1;
//                    if (j-i+1>max) {
//                        max = j - i + 1;
//                        start = i;
//                        end = j + 1;
//                    }
//                }
//            }
//        }
//        return s.substring(start, end);
//    }

    // Extend around center
    // Time: O(n^2), space: constant
    private String res="";

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++){
            extend(s, i, i);
            extend(s, i, i+1);
        }
        return res;
    }

    public void extend(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--; j++;
        }
        if (j - i - 1 > res.length()){
            res = s.substring(i+1, j);
        }
    }
}
