package Leetcode.String;

public class RotateString_796 {
//    public boolean rotateString(String A, String B) {
//        if (A.length() != B.length()) {
//            return false;
//        }
//        // corner case: A="", B=""
//        if (A.length() == 0 && B.length() == 0) {
//            return true;
//        }
//        for (int i = 0; i < A.length(); i++) {
//            if (A.charAt(i) == B.charAt(0)) {
//                String str = A.substring(i) + A.substring(0, i);
//                if (str.equals(B)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).indexOf(B) != -1;
    }
}
