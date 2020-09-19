package Leetcode.TwoPointers;

import java.util.Arrays;

public class ThreeSumSmaller_259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = nums.length-1;
            int tar = target - nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] < tar) {
                    ans += hi - lo;
                    lo ++;
                } else {
                    hi --;
                }
            }
        }
        return ans;
    }
}
