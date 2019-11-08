package Leetcode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            //avoid duplicate solutions
            if (i>start && candidates[i]==candidates[i-1])
                continue;
            list.add(candidates[i]);
            search(candidates, list, result, target-candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        CombinationSum2_40 obj = new CombinationSum2_40();
        obj.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
