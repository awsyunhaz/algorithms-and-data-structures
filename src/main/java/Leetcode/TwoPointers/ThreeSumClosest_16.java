package Leetcode.TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        for (int i=0; i<nums.length-2; i++){
            int lo=i+1, hi=nums.length-1;
            while (lo<hi){
                int sum = nums[i]+nums[lo]+nums[hi];
                if (Math.abs(sum-target)<Math.abs(result-target)) {
                    result = sum;
                }
                if (sum-target<0)
                    lo++;
                else
                    hi--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        ThreeSumClosest_16 obj = new ThreeSumClosest_16();
        System.out.println(obj.threeSumClosest(new int[]{1,1,-1,-1,3},-1));
    }
}
