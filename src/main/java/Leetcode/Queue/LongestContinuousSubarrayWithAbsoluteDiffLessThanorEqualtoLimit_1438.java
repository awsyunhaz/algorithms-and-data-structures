package Leetcode.Queue;

import java.util.LinkedList;
import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit_1438 {
    // O(n^2)
//    public int longestSubarray(int[] nums, int limit) {
//        int min = nums[0], max = nums[0], res = 0, len = 0;
//        for (int i = 0; i < nums.length; i++) {
//            min = Math.min(nums[i], min);
//            max = Math.max(nums[i], max);
//            if (max - min <= limit) {
//                len ++;
//                res = Math.max(res, len);
//            } else {
//                int j = i;
//                min = nums[i];
//                max = nums[i];
//                len = 0;
//                while (Math.abs(nums[j] - min) <= limit && Math.abs(nums[j] - max) <= limit) {
//                    max = Math.max(max, nums[j]);
//                    min = Math.min(min, nums[j]);
//                    j--;
//                    len ++;
//                }
//            }
//        }
//        return res;
//    }

    // O(nlogn)
//    public int longestSubarray(int[] nums, int limit) {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        int i = 0;
//        for (int j = 0; j < nums.length; j++) {
//            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
//            if (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
//                map.put(nums[i], map.get(nums[i]) - 1);
//                if (map.get(nums[i]) == 0) {
//                    map.remove(nums[i]);
//                }
//                i++;
//            }
//        }
//        return nums.length-i;
//    }

    // max/min queue, O(n)
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int res = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // keep max queue in decreasing order
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[j]) {
                maxQueue.pollLast();
            }
            // keep min queue in increasing order
            maxQueue.addLast(nums[j]);
            while (!minQueue.isEmpty() && minQueue.peekLast() > nums[j]) {
                minQueue.pollLast();
            }
            minQueue.addLast(nums[j]);
            while (maxQueue.peek() - minQueue.peek() > limit) {
                if (maxQueue.peek() == nums[i]) {
                    maxQueue.pop();
                }
                if (minQueue.peek() == nums[i]) {
                    minQueue.pop();
                }
                i ++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}
