package Leetcode.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_239 {
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
