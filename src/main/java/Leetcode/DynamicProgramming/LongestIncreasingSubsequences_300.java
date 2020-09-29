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
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res;
    }

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
//    public int lengthOfLIS(int[] nums) {
//        int[] arr = new int[nums.length];
//        int size = 0;
//        for (int num: nums){
//            if (size == 0){
//                arr[size] = num;
//                size++;
//            } else if (num > arr[size -1]){
//                arr[size] = num;
//                size++;
//            } else {
//                int lo = 0, hi = size;
//                while (lo < hi) {
//                    int mid = (lo + hi) / 2;
//                    if (arr[mid] < num)
//                        lo = mid + 1;
//                    else
//                        hi = mid;
//                }
//                arr[lo] = num;
//            }
//        }
//        return size;
//    }

    // Greedy + binary Search implemented in array list
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(nums[0]);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > arr.get(arr.size()-1))
//                arr.add(nums[i]);
//            else {
//                int lo = 0, hi = arr.size();
//                while (lo < hi) {
//                    int mid = (lo + hi) / 2;
//                    if (nums[i] > arr.get(mid)) {
//                        lo = mid + 1;
//                    } else {
//                        hi = mid;
//                    }
//                }
//                arr.set(lo, nums[i]);
//            }
//        }
//        return arr.size();
//    }
}
