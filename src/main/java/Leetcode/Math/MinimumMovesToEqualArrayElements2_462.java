package Leetcode.Math;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements2_462 {
    // sort, O(nlogn)
//    public int minMoves2(int[] nums) {
//        Arrays.sort(nums);
//        int res = 0;
//        for (int num: nums) {
//            res += Math.abs(num - nums[nums.length/2]);
//        }
//        return res;
//    }

    // quick select, O(n)
    public int minMoves2(int[] nums) {
        quickSelect(nums, nums.length/2, 0, nums.length-1);
        int res = 0;
        for (int num: nums) {
            res += Math.abs(num - nums[nums.length/2]);
        }
        return res;
    }

    public void quickSelect(int[] nums, int k, int lo, int hi) {
        if (lo < hi) {
            int mid = partition(nums, lo, hi);
            if (mid < k) {
                quickSelect(nums, k, mid+1, hi);
            } else if (mid > k) {
                quickSelect(nums, k, lo, mid-1);
            }
        }
    }

    public int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) hi --;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] < pivot) lo ++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}
