package Leetcode.String;

public class IsOneDistance_161 {
//    public boolean isOneEditDistance(String s, String t) {
//        int m = s.length(), n = t.length();
//        if (Math.abs(m - n) >= 2) {
//            return false;
//        }
//        int i = 0, j = 0;
//        while (i < m && j < n && s.charAt(i) == t.charAt(j)){
//            i ++;
//            j ++;
//        }
//        if (m > n) {
//            if (j == n) {
//                return m - n == 1;
//            }
//            return s.substring(i+1, m).equals(t.substring(i, n));
//        } else if (m < n) {
//            if (i == m) {
//                return n - m == 1;
//            }
//            return s.substring(i, m).equals(t.substring(i+1, n));
//        } else {
//            if (i == m && j == n) {
//                return false;
//            }
//            return s.substring(i+1, m).equals(t.substring(i+1, n));
//        }
//    }


    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        // Make s shorter than t
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        if (n - m >= 2) {
            return false;
        }
        int i = 0;
        while (i < m && s.charAt(i) == t.charAt(i)){
            i ++;
        }
        if (i == m) {
            return n - m == 1;
        } else {
            if (m == n) {
                return s.substring(i+1, m).equals(t.substring(i+1, n));
            }
            else { // m + 1 == n
                return s.substring(i, m).equals(t.substring(i+1, n));
            }
        }
    }
}
