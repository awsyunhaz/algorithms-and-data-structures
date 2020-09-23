package Leetcode.DynamicProgramming;

import java.util.ArrayList;

public class LongestIncreasingSubsequences {

    // backtrack, O(2^n), TLE
//    public int lengthOfLIS(int[] nums) {
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, lis(nums, i));
//        }
//        return max;
//    }
//
//    public int lis(int[] nums, int i) {
//        if (i == nums.length-1) {
//            return 1;
//        }
//        int max = 1;
//        for (int j = i+1; j < nums.length; j++) {
//            if (nums[j] > nums[i]) {
//                max = Math.max(max, lis(nums, j)+1);
//            }
//        }
//        return max;
//    }

    // backtrack with memorization, O(n^2), 20ms
//    public int lengthOfLIS(int[] nums) {
//        int max = 0;
//        int[] memory = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, lis(nums, i, memory));
//        }
//        return max;
//    }
//
//    public int lis(int[] nums, int i, int[] memory) {
//        if (memory[i] > 0) {
//            return memory[i];
//        }
//        if (i == nums.length-1) {
//            return 1;
//        }
//        int max = 1;
//        for (int j = i+1; j < nums.length; j++) {
//            if (nums[j] > nums[i]) {
//                max = Math.max(max, lis(nums, j, memory)+1);
//            }
//        }
//        memory[i] = max;
//        return max;
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
