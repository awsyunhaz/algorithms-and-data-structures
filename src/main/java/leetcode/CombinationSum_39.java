package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        search(candidates, list, result, target, 0);
        for (List<Integer> temp: result)
            System.out.println(temp);
        return result;
    }

    public void search(int[] candidates, List<Integer> list,
                       List<List<Integer>> result, int target, int start){
        if (target<0)
            return;
        if (target==0)
            result.add(new ArrayList<>(list));
        for (int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            // Can use the same element again
            search(candidates, list, result, target-candidates[i], i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        CombinationSum_39 obj = new CombinationSum_39();
        obj.combinationSum(new int[]{2,3,6,7}, 7);
    }
}
