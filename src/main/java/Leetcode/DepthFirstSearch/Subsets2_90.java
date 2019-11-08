package Leetcode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        search(nums, list, result, 0);
        for (List<Integer> temp: result)
            System.out.println(temp);
        return result;
    }

    private void search(int nums[], List<Integer> list,
                        List<List<Integer>> result, int start){
        result.add(new ArrayList<>(list));
        for (int i=start; i<nums.length; i++){
            if (i>start && nums[i]==nums[i-1])
                continue;
            list.add(nums[i]);
            search(nums, list, result, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        Subsets2_90 obj = new Subsets2_90();
        obj.subsetsWithDup(new int[]{1,1,2,2});
    }
}
