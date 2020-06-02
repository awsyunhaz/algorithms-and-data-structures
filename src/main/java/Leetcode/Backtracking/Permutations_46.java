package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_46 {

    // iterative solution
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> lis = Arrays.asList(nums[0]);
//        res.add(lis);
//        for (int i = 1; i < nums.length; i++) {
//            List<List<Integer>> new_res = new ArrayList<>();
//            for (List<Integer> l: res) {
//                for (int pos = 0; pos <= i; pos++) {
//                    List<Integer> new_lis = new ArrayList<>(l);
//                    new_lis.add(pos, nums[i]);
//                    new_res.add(new_lis);
//                }
//            }
//            res = new_res;
//        }
//        return res;
//    }

    // O(n!), recursive
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lis = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        recursion(res, lis, nums, used);
        return res;
    }

    public void recursion(List<List<Integer>> res, List<Integer> lis, int[] nums, boolean[] used) {
        if (lis.size() == nums.length) {
            res.add(new ArrayList<>(lis));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                lis.add(nums[i]);
                recursion(res, lis, nums, used);
                used[i] = false;
                lis.remove(lis.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Permutations_46 obj = new Permutations_46();
        obj.permute(new int[]{1,2,3});
    }
}
