package Leetcode.DynamicProgramming;

public class DecodeWays_91 {
    // Recursion - O(2^n) TLE
//    public int numDecodings(String s) {
//        return search(s, 0);
//    }
//
//    public int search(String s, int ind) {
//        if (ind == s.length()) {
//            return 1;
//        }
//        if (s.charAt(ind) == '0') {
//            return 0;
//        }
//        if (ind < s.length()-1) {
//            Integer num = Integer.parseInt(s.substring(ind, ind+2));
//            if (num >= 10 && num <= 26) {
//                return search(s, ind+1) + search(s, ind+2);
//            }
//        }
//        return search(s, ind+1);
//    }

    public int numDecodings(String s) {
        int[] f = new int[s.length()+1];
        f[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        f[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int f1 = 0, f2 = 0;
            int num = Integer.parseInt(s.substring(i-2, i));
            if (num >= 10 && num <= 26) {
                f2 = f[i-2];
            }
            if (s.charAt(i-1) != '0') {
                f1 = f[i-1];
            }
            f[i] = f1 + f2;
        }
        return f[s.length()];
    }
}
