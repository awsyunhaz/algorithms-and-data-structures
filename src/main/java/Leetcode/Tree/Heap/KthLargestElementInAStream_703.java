package Leetcode.Tree.Heap;

import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {
    PriorityQueue<Integer> pq;
    int size;

    public KthLargestElementInAStream_703(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;
        for (int num: nums) {
            pq.offer(num);
            if (pq.size() > size) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > size) {
            pq.poll();
        }
        return pq.peek();
    }
}
