package Leetcode.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_239 {

    // O(nk)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        if (n == 0)
//            return new int[]{};
//        int[] res = new int[n - k + 1];
//        for (int i = 0; i + k <= n; i++) {
//            int max = nums[i];
//            for (int j = i + 1; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            res[i] = max;
//        }
//        return res;
//    }

    // O(n), a element can only be add and poll once
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return new int[]{};
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[n-k+1];
        int ind = 0;
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peek() < i-k+1) {
                queue.poll();
            }
            // keep the max queue in decreasing order
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[ind++] = nums[queue.peek()];
            }
        }
        return res;
    }
}
