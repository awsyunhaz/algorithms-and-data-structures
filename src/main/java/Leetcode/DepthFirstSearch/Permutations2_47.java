package Leetcode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        search(nums, list, result, new boolean[nums.length]);
        for (List<Integer> temp: result)
            System.out.println(temp);
        return result;
    }

    private void search(int nums[], List<Integer> list,
                        List<List<Integer>> result, boolean[] used){
        if (list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (used[i] || i>0 && !used[i-1] && nums[i]==nums[i-1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            search(nums, list, result, used);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args){
        Permutations2_47 obj = new Permutations2_47();
        obj.permuteUnique(new int[]{3,3,0,3});
    }
}
