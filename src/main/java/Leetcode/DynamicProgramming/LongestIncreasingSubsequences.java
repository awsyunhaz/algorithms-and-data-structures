package Leetcode.DynamicProgramming;

public class LongestIncreasingSubsequences {

    // DP - O(n^2)
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//        int[] arr = new int[nums.length];
//        for (int i = 0; i < nums.length; i++){
//            arr[i] = 1;
//        }
//        int max = 1;
//        for (int i = 1; i < nums.length; i++){
//            for (int j = 0; j < i; j++){
//                if (nums[i] > nums[j]){
//                    arr[i] = Math.max(arr[i], arr[j] + 1);
//                }
//                max = Math.max(arr[i], max);
//            }
//        }
//        return max;
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
}
