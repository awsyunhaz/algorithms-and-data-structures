package Leetcode.DynamicProgramming;

import java.util.ArrayList;

public class LongestIncreasingSubsequences {

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

    // Binary Search - O(nlgn)
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int size = 0;
        for (int num: nums){
            if (size == 0){
                arr[size] = num;
                size++;
            } else if (num > arr[size -1]){
                arr[size] = num;
                size++;
            } else {
                int lo = 0, hi = size;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (arr[mid] < num)
                        lo = mid + 1;
                    else
                        hi = mid;
                }
                arr[lo] = num;
            }
        }
        return size;
    }

    // Binary search implemented in arr list
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
