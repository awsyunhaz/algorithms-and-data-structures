package Leetcode.HashMap;

import java.util.HashMap;

public class DegreeOfAnArray_697 {
    public int findShortestSubArray(int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int degree = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        HashMap<Integer, Integer> firstInd = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            if (!firstInd.containsKey(nums[i])) {
                firstInd.put(nums[i], i);
            }
            if (counter.get(nums[i]) > degree) {
                degree = counter.get(nums[i]);
                minLen = i - firstInd.get(nums[i]);
            } else if (counter.get(nums[i]) == degree) {
                minLen = Math.min(i - firstInd.get(nums[i]), minLen);
            }
        }
        return minLen+1;
    }
}
