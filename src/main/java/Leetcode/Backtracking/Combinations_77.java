package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        search(res, curr, k, n, 1);
        return res;
    }

    public void search(List<List<Integer>> res, List<Integer> curr, int k, int n, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n-k+1; i++) {
            curr.add(i);
            search(res, curr, k-1, n, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
