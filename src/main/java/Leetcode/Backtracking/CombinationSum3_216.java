package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(res, curr, k, n, 1);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> curr, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (n < 0 || k < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            dfs(res, curr, k-1, n-i, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
