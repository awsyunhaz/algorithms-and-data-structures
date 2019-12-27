package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        search(nums, list, result);
        for (List<Integer> temp: result)
            System.out.println(temp);
        return result;
    }

    private void search(int nums[], List<Integer> list,
                        List<List<Integer>> result){
        if (list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            search(nums, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        Permutations_46 obj = new Permutations_46();
        obj.permute(new int[]{1,2,3});
    }
}
