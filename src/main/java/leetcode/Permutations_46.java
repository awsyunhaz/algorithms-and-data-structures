package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        search(nums, list, result, 0);
        for (List<Integer> temp: result)
            System.out.println(temp);
        return result;
    }

    private void search(int nums[], List<Integer> list,
                        List<List<Integer>> result, int start){
        if (list.size()==nums.length){
            System.out.println(list);
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<nums.length; i++){
            list.add(nums[i]);
            search(nums, list, result, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        Permutations_46 obj = new Permutations_46();
        obj.permute(new int[]{1,2,3});
    }
}
