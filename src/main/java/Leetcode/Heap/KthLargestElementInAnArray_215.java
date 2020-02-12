package Leetcode.Heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {

//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
//        for (int num: nums) {
//            pq.offer(num);
//        }
//        for (int i = 0; i < k-1; i++) {
//            pq.poll();
//        }
//        return pq.poll();
//    }
//
//    public int findKthLargest(int[] nums, int k) {
//        quickselect(nums, 0, nums.length-1, k);
//        return nums[k-1];
//    }

    // Quick select - O(n)
    public void quickselect(int[] nums, int lo, int hi, int k) {
        if (lo < hi) {
            int mid = partition(nums, lo, hi);
            if (k < mid+1) {
                quickselect(nums, lo, mid-1, k);
            } else if (k > mid+1) {
                quickselect(nums, mid+1, hi, k);
            }
        }
    }

    public int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] <= pivot) hi--;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] > pivot) lo ++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}
