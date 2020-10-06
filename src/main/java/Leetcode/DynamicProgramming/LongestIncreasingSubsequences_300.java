package Leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequences_300 {

    // backtrack, O(2^n), TLE
//    public int lengthOfLIS(int[] nums) {
//        int maxLen = 0;
//        for (int i = 0; i < nums.length; i++) {
//            maxLen = Math.max(maxLen, lengthOfLIS(nums, i) + 1);
//        }
//        return maxLen;
//    }
//
//    public int lengthOfLIS(int[] nums, int start) {
//        int maxLen = 0;
//        for (int i = start+1; i < nums.length; i++) {
//            if (nums[i] > nums[start]) {
//                maxLen = Math.max(maxLen, lengthOfLIS(nums, i) + 1);
//            }
//        }
//        return maxLen;
//    }

    // backtrack with memorization, O(n^2), 20ms
//    public int lengthOfLIS(int[] nums) {
//        int[] mem = new int[nums.length];
//        Arrays.fill(mem, -1);
//        int maxLen = 0;
//        for (int i = 0; i < nums.length; i++) {
//            maxLen = Math.max(maxLen, lengthOfLIS(nums, i, mem) + 1);
//        }
//        return maxLen;
//    }
//
//    public int lengthOfLIS(int[] nums, int start, int[] mem) {
//        if (mem[start] >= 0) {
//            return mem[start];
//        }
//        int maxLen = 0;
//        for (int i = start+1; i < nums.length; i++) {
//            if (nums[i] > nums[start]) {
//                maxLen = Math.max(maxLen, lengthOfLIS(nums, i, mem) + 1);
//            }
//        }
//        mem[start] = maxLen;
//        return maxLen;
//    }

    // DP - O(n^2)
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//        int res = 1;
//        int[] dp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++){
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                    res = Math.max(dp[i], res);
//                }
//            }
//        }
//        return res;
//    }

    // Greedy, O(n^2)
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int size = 1;
//        int[] lis = new int[nums.length];
//        lis[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > lis[size-1]) {
//                lis[size++] = nums[i];
//            } else {
//                int ind = size - 1;
//                while (ind - 1 >= 0 && lis[ind - 1] >= nums[i])
//                    ind--;
//                lis[ind] = nums[i];
//            }
//        }
//        return size;
//    }

    // Greedy + binary Search - O(nlgn)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ind = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[ind]) {
                nums[++ind] = nums[i];
            } else if (nums[i] < nums[ind]) {
                // find the first number greater than or equal to target
                int lo = 0, hi = ind;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (nums[mid] < nums[i]) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                nums[lo] = nums[i];
            }
        }
        return ind + 1;
    }
}
