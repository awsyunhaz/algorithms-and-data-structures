package Leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Sort + 2 pointer - O(N^2)
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi){
                while (lo < hi && nums[lo] + nums[hi] + nums[i] < 0)
                    lo++;
                while (lo < hi && nums[lo] + nums[hi] + nums[i] > 0)
                    hi--;
                if (lo < hi && nums[lo] + nums[hi] + nums[i] == 0){
                    res.add(Arrays.asList(nums[lo], nums[hi], nums[i]));
                    while (lo < hi && nums[lo] == nums[++lo]);
                    while (lo < hi && nums[hi] == nums[--hi]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        ThreeSum_15 obj = new ThreeSum_15();
        System.out.println(obj.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
