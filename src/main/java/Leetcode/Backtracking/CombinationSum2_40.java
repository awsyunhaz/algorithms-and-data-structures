package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        search(res, list, candidates, 0, target);
        return res;
    }

    public void search(List<List<Integer>> res, List<Integer> list, int[] candidates, int start, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i == start || candidates[i] != candidates[i-1]) {
                list.add(candidates[i]);
                search(res, list, candidates, i+1, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        CombinationSum2_40 obj = new CombinationSum2_40();
        obj.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
