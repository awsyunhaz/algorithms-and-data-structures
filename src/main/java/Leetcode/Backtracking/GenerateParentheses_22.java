package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        recursion(res, sb, 0, 0, n);
        return res;
    }

    public void recursion(List<String> res, StringBuffer sb, int left, int right, int n) {
        if (sb.length() == 2*n) {
            res.add(sb.toString());
        }
        if (left < n) {
            sb.append('(');
            recursion(res, sb, left+1, right, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left) {
            sb.append(')');
            recursion(res, sb, left, right+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
