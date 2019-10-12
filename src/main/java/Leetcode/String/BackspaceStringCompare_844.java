package Leetcode.String;

public class BackspaceStringCompare_844 {
    public boolean backspaceCompare(String S, String T) {
        return type(S).equals(type(T));
    }

    public String type(String str) {
        StringBuffer res = new StringBuffer();
        for (char c: str.toCharArray()) {
            if (c != '#') {
                res.append(c);
            } else {
                if (res.length() > 0)
                    res.deleteCharAt(res.length() - 1);
            }
        }
        return res.toString();
    }
}
