package Leetcode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    // Backtrack - 1ms
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        search(res, "", n, 0, 0);
        return res;
    }

    public void search(List<String> res, String str,
                       int n, int left, int right){
        if (str.length()==n*2){
            res.add(str);
            return;
        }
        if (left<n)
            search(res, str+'(', n, left+1, right);
        if (right<left)
            search(res, str+')', n, left, right+1);
    }
}
