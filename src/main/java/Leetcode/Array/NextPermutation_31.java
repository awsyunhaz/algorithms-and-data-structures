package Leetcode.Array;

import java.util.Arrays;

public class NextPermutation_31 {
//    public void nextPermutation(int[] nums) {
//        if (nums.length == 0 || nums.length == 1) {
//            return;
//        }
//        int i = nums.length - 2;
//        while (i >= 0 && nums[i] >= nums[i+1]) i--;
//
//        // the array is in descending order
//        if (i == -1) {
//            Arrays.sort(nums);
//            return;
//        }
//        // find the one just larger than nums[i]
//        int j = nums.length-1;
//        while (nums[j] <= nums[i]) j--;
//
//        // swap nums[i] and nums[j]
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//
//        // sort array behind pos i
//        Arrays.sort(nums, i+1, nums.length);
//    }

    // O(n)
    // 本解针对于next permutation为不同排列的情况。如：115的下一个为151，而非115
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        if (i == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int j = nums.length-1;
        while (nums[j] <= nums[i]) j--;

        // swap nums[i] and nums[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

        // elements behind i+1 are in descending order -> reverse
        reverse(nums, i+1, nums.length-1);
    }

    public void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo ++;
            hi --;
        }
    }
}
