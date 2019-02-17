package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length-3; i++){
            if (i>0 && nums[i-1]==nums[i])
                continue;
            for (int j=i+1; j<nums.length-2; j++){
                if (j>i+1 && nums[j-1]==nums[j])
                    continue;
                int lo = j+1, hi = nums.length-1;
                while (lo<hi){
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum==target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                        while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                        lo++; hi--;
                    }
                    else if (sum<target)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        FourSum_18 obj = new FourSum_18();
        System.out.println(obj.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}
