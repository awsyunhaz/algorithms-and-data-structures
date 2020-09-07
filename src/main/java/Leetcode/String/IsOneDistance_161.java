package Leetcode.String;

public class IsOneDistance_161 {

//    public boolean isOneEditDistance(String s, String t) {
//        int m = s.length(), n = t.length();
//        // Make s shorter than t
//        if (m > n) {
//            return isOneEditDistance(t, s);
//        }
//        if (n - m >= 2) {
//            return false;
//        }
//        int i = 0;
//        while (i < m && s.charAt(i) == t.charAt(i)){
//            i ++;
//        }
//        if (i == m) {
//            return n - m == 1;
//        } else {
//            if (m == n) {
//                return s.substring(i+1, m).equals(t.substring(i+1, n));
//            }
//            else { // m + 1 == n
//                return s.substring(i, m).equals(t.substring(i+1, n));
//            }
//        }
//    }

    // be careful to corner cases
//    public boolean isOneEditDistance(String s, String t) {
//        int slen = s.length(), tlen = t.length();
//        if (Math.abs(slen - tlen) >= 2) {
//            return false;
//        }
//        int i = 0, j = 0;
//        while (i < slen && j < tlen && s.charAt(i) == t.charAt(j)) {
//            i ++;
//            j ++;
//        }
//        if (i == slen || j == tlen) {
//            // slen == tlen: s and t are equal
//            return slen != tlen;
//        }
//        if (slen == tlen) {
//            return s.substring(i+1).equals(t.substring(j+1));
//        } else if (slen > tlen) {
//            return s.substring(i+1).equals(t.substring(j));
//        } else {
//            return s.substring(i).equals(t.substring(j+1));
//        }
//    }

    public boolean isOneEditDistance(String s, String t) {
        // make s shorter than t
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        for (int i = 0; i < s.length(); i++) {
            // find difference: check delete or replace
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i+1).equals(t.substring(i+1)) || s.substring(i).equals(t.substring(i+1));
            }
        }
        return t.length() - s.length() == 1;
    }

}
