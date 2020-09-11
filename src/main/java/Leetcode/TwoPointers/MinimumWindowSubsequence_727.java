package Leetcode.TwoPointers;

public class MinimumWindowSubsequence_727 {
    // O(n^2)
//    public String minWindow(String S, String T) {
//        String res = "";
//        int min = S.length();
//        for (int start = 0; start < S.length(); start++) {
//            if (S.charAt(start) == T.charAt(0)) {
//                int end = start, i = 0;
//                while (end < S.length() && i < T.length()) {
//                    if (S.charAt(end++) == T.charAt(i)) {
//                        i ++;
//                    }
//                }
//                if (i == T.length() && end - start < min) {
//                    res = S.substring(start, end);
//                    min = end - start;
//                }
//            }
//        }
//        return res;
//    }

    // Two pointers, O(n^2)
    public String minWindow(String S, String T) {
        String res = "";
        int min = S.length();
        int sind = 0, tind = 0;
        while (sind < S.length()) {
            if (S.charAt(sind++) == T.charAt(tind)) {
                tind ++;
            }
            if (tind == T.length()) {
                int end = sind;
                tind --;
                while (tind >= 0) {
                    if (S.charAt(--sind) == T.charAt(tind)) {
                        tind --;
                    }
                }
                if (end - sind < min) {
                    min = end - sind;
                    res = S.substring(sind, end);
                }
                sind ++;
                tind = 0;
            }
        }
        return res;
    }
}
