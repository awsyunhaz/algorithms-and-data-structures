package leetcode.DeepFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
//        result.add(new ArrayList<>(list));
        search(nums, list, result, 0);
        for (List<Integer> temp: result)
            System.out.println(temp);
        return result;
    }

    private void search(int nums[], List<Integer> list,
                         List<List<Integer>> result, int start){
        result.add(new ArrayList<>(list));
        for (int i=start; i<nums.length; i++){
            list.add(nums[i]);
            search(nums, list, result, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        Subsets_78 obj = new Subsets_78();
        obj.subsets(new int[]{1,2,3});
    }
}
