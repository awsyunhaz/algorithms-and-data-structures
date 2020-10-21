package Leetcode.Tree.Heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian_480 {
    // O(nlogk)
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return b.compareTo(a);
//            }
//        });
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        double[] res = new double[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (!maxQueue.remove(nums[i-k])) {
                    minQueue.remove(nums[i-k]);
                }
            }
            maxQueue.add(nums[i]);
            minQueue.add(maxQueue.poll());
            while (minQueue.size() > maxQueue.size()) {
                maxQueue.add(minQueue.poll());
            }
            if (i >= k-1) {
                if (k % 2 == 0) {
                    res[i-k+1] = (maxQueue.peek()*1.0 + minQueue.peek()*1.0)/2;
                } else {
                    res[i-k+1] = maxQueue.peek()*1.0;
                }
            }
        }
        return res;
    }
}
