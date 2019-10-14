package Leetcode.String;

public class BackspaceStringCompare_844 {
//    public boolean backspaceCompare(String S, String T) {
//        return type(S).equals(type(T));
//    }

//    public String type(String str) {
//        StringBuffer res = new StringBuffer();
//        for (char c: str.toCharArray()) {
//            if (c != '#') {
//                res.append(c);
//            } else {
//                if (res.length() > 0)
//                    res.deleteCharAt(res.length() - 1);
//            }
//        }
//        return res.toString();
//    }

    // Two pointer backward - O(1) space
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int backs = 0, backt = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (backs > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') backs ++;
                else backs --;
                i --;
            }
            while (j >= 0 && (backt > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') backt ++;
                else backt --;
                j --;
            }
            if (i == -1 && j == -1)
                return true;
            if (i == -1 || j == -1 || S.charAt(i) != T.charAt(j))
                return false;
            i--;
            j--;
        }
        if (i == -1 && j == -1)
            return true;
        return false;
    }
}
