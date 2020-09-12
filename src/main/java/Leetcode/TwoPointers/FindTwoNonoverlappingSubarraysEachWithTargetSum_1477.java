package Leetcode.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum_1477 {
    // Hash map
//    public int minSumOfLengths(int[] arr, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        // min previous subarray
//        int[] min = new int[arr.length];
//        Arrays.fill(min, Integer.MAX_VALUE);
//        map.put(0, -1);
//        int res = Integer.MAX_VALUE, sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//            if (i > 0) {
//                min[i] = min[i-1];
//            }
//            if (map.containsKey(sum - target)) {
//                int left = map.get(sum - target);
//                if (left >= 0 && min[left] != Integer.MAX_VALUE) {
//                    res = Math.min(res, min[left] + i - left);
//                }
//                min[i] = Math.min(min[i], i - left);
//            }
//            map.put(sum, i);
//        }
//        return res == Integer.MAX_VALUE? -1: res;
//    }

    // Sliding window, no need Hashmap given arr[i] > 0
    public int minSumOfLengths(int[] arr, int target) {
        // min previous subarray
        int[] min = new int[arr.length];
        Arrays.fill(min, Integer.MAX_VALUE);
        int res = Integer.MAX_VALUE, sum = 0, left = -1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[++left];
            }
            if (i > 0) {
                min[i] = min[i-1];
            }
            if (sum == target) {
                if (left >= 0 && min[left] != Integer.MAX_VALUE) {
                    res = Math.min(res, min[left] + i - left);
                }
                min[i] = Math.min(min[i], i - left);
            }
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}
