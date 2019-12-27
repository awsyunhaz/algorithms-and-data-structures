package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        search(res, curr, nums, 0);
        return res;
    }

    public void search(List<List<Integer>> res, List<Integer> curr, int[] nums, int start) {
        res.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            search(res, curr, nums, i+1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args){
        Subsets_78 obj = new Subsets_78();
        obj.subsets(new int[]{1,2,3});
    }
}
